package com.lgm.backend.service;

import com.lgm.backend.dto.BetDto;
import com.lgm.backend.dto.BetPage;
import com.lgm.backend.dto.MatchDto;
import com.lgm.backend.dto.TeamDto;
import com.lgm.backend.model.backendDb.Bet;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.model.mainDb.Match;
import com.lgm.backend.model.mainDb.Team;
import com.lgm.backend.repository.backendDb.BetRepository;

import com.lgm.backend.repository.backendDb.UserRepository;
import com.lgm.backend.repository.mainDb.MatchRepository;

import com.lgm.backend.repository.mainDb.TeamRepository;
import com.lgm.backend.security.JwtUtilities;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
@RequiredArgsConstructor
public class BetService {

    private final PointService pointService;
    private final JwtUtilities jwtUtilities;
    private final UserService userService;

    private final BetRepository betRepository;
    private final MatchRepository matchRepository;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    Integer PAGE_SIZE = 25;
    private final ModelMapper modelMapper;


    public BetDto addBet(String token, Integer match_id, Integer betTeam, Float amount){
        String email = jwtUtilities.extractUsername(token);

        Optional<Match> matchOptional = matchRepository.findById(match_id);
        Optional<User> userOptional = userService.getUser(email);
        boolean betExist = betRepository.existsByMatchIdAndUserId_Email(match_id,email);


        if ( userOptional.isEmpty()|| matchOptional.isEmpty()|| betExist|| amount<0){
            return new BetDto();
        }

        User user = userOptional.get();
        Match match = matchOptional.get();

        Integer idAway = match.getAway().getId();
        Integer idHome = match.getHome().getId();

        if (pointService.getPoint(email) < amount || match.getStatus().equals("finished")){
            return new BetDto();
        }

        Float odd = idAway.equals(betTeam)?match.getAwayOdd():match.getHomeOdd();
        try {
            pointService.remove(amount, email);
            Bet bet = betRepository.save(new Bet(user, match_id, betTeam, amount, odd));

            BetDto betDto = new BetDto();

            betDto.setId(bet.getId());
            betDto.setMatchId(modelMapper.map(match, MatchDto.class));

            Team team = teamRepository.getReferenceById(bet.getBetTeamId());
            betDto.setBetTeamId(modelMapper.map(team, TeamDto.class));
            betDto.setAmount(bet.getAmount());
            betDto.setOdd(bet.getOdd());
            betDto.setIsFinished(bet.getIsFinished());
            betDto.setWinnerId(bet.getWinnerId());

            return betDto;

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
                bet.setWinnerId(match.getWinner().getId());
                betRepository.save(bet);
            }
        }
    }

    public BetPage getAllBetByPage(Integer page, String token){
        String email = jwtUtilities.extractUsername(token);

        Page<Bet> betPage = betRepository.findhistory(PageRequest.of(page-1,PAGE_SIZE),email);
        List<BetDto> betDtoList = new ArrayList<>();

        for (Bet bet:betPage){

            BetDto betDto = new BetDto();

            betDto.setId(bet.getId());

            Match match = matchRepository.getReferenceById(bet.getMatchId());
            betDto.setMatchId(modelMapper.map(match, MatchDto.class));

            Team team = teamRepository.getReferenceById(bet.getBetTeamId());
            betDto.setBetTeamId(modelMapper.map(team, TeamDto.class));

            betDto.setAmount(bet.getAmount());
            betDto.setOdd(bet.getOdd());
            betDto.setIsFinished(bet.getIsFinished());
            betDto.setWinnerId(bet.getWinnerId());

            betDtoList.add(betDto);

        }


        int totalPage = betPage.getTotalPages();

        BetPage result = new BetPage();
        result.setTotalPages(totalPage);
        result.setSeries(betDtoList);
        return result;

    }


    



}
