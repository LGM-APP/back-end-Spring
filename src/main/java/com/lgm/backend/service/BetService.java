package com.lgm.backend.service;

import com.lgm.backend.dto.BetDto;
import com.lgm.backend.dto.BetPage;
import com.lgm.backend.model.backendDb.Bet;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.model.mainDb.Match;
import com.lgm.backend.repository.backendDb.BetRepository;

import com.lgm.backend.repository.backendDb.UserRepository;
import com.lgm.backend.repository.mainDb.MatchRepository;

import com.lgm.backend.security.JwtUtilities;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.io.Console;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BetService {

    private final PointService pointService;
    private final JwtUtilities jwtUtilities;
    private final UserService userService;

    private final BetRepository betRepository;
    private final MatchRepository matchRepository;
    private final UserRepository userRepository;

    Integer PAGE_SIZE = 25;
    private final ModelMapper modelMapper;


    public Bet addBet(String token, Integer match_id, Integer betTeam, Float amount){
        String email = jwtUtilities.extractUsername(token);

        Optional<Match> matchOptional = matchRepository.findById(match_id);
        Optional<User> userOptional = userService.getUser(email);
        boolean betExist = betRepository.existsByMatchIdAndUserId_Email(match_id,email);

        if ( userOptional.isEmpty()|| matchOptional.isEmpty()|| betExist){
            return new Bet(null,null,null,null,null);
        }

        User user = userOptional.get();
        Match match = matchOptional.get();

        Integer idAway = match.getAway().getId();
        Integer idHome = match.getHome().getId();

        if (pointService.getPoint(email) < amount || match.getStatus().equals("finished")){
            return new Bet(null,null,null,null,null);
        }

        Float odd = idAway.equals(betTeam)?match.getAwayOdd():match.getHomeOdd();


        pointService.remove(amount,email);

        try {
            pointService.remove(amount, email);
            return betRepository.save(new Bet(user, match_id, betTeam, amount, odd));
        } catch (CannotAcquireLockException e) {
            return addBet(token, match_id, betTeam, amount);
        }
    }

    public List<Bet> getBetByEmail(String token){
        return betRepository.findByUserId_Email(jwtUtilities.extractUsername(token));
    }

    public void checkBet(){
        List<Bet> bets = new ArrayList<>(betRepository.findByIsFinished(false)) {};


        for (Bet bet:bets){

            Optional<User> userOptional = userRepository.findById(bet.getUserId().getId());
            Optional<Match> matchOptional = matchRepository.findById(bet.getMatchId());

            if (matchOptional.isEmpty() || userOptional.isEmpty()){continue;}

            User user = userOptional.get();
            Match match = matchOptional.get();

            if (match.getStatus().equals("finished")){
                if (Objects.equals(match.getWinner().getId(), bet.getBetTeamId())){
                    pointService.addPointOdd(bet.getOdd(), bet.getAmount(), user.getEmail());
                }
                bet.setIsFinished(true);
                betRepository.save(bet);
            }
        }
    }

   // public BetPage getAllBetByPage(Integer page, String token){
   //     String email = jwtUtilities.extractUsername(token);
   //
   //     Page<Bet> betPage = betRepository.findByUserId_EmailOrderByDescGroupByIsfinished(PageRequest.of(page-1,PAGE_SIZE),email);
   //     List<BetDto> betDtoList = betPage.stream().toList().stream().map((element) -> modelMapper.map(element, BetDto.class)).toList();
   //     int totalPage = betPage.getTotalPages();
   //
   //     BetPage result = new BetPage();
   //     result.setTotalPages(totalPage);
   //     result.setSeries(betDtoList);
   //     return result;
   //
   // }


    



}
