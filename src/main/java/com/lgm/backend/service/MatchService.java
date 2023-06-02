package com.lgm.backend.service;



import com.lgm.backend.dto.MatchDto;
import com.lgm.backend.dto.MatchPage;
import com.lgm.backend.dto.TeamDto;
import com.lgm.backend.dto.TeamPage;
import com.lgm.backend.model.mainDb.Match;
import com.lgm.backend.repository.mainDb.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final ModelMapper modelMapper;

    Integer PAGE_SIZE = 10;

    public List<Match> getMatchByTournamentId(Integer id){
        return matchRepository.findAllByBeginAtAfterAndTournamentId(LocalDateTime.now(),id);
    }

    public MatchPage getAllMatchDontBegin(Integer page){
        Page<Match> matchPage =  matchRepository.findAllByAway_NameNotLikeAndHome_NameNotLikeAndStatusNotLikeAndBeginAtBetweenAndAwayNotNullAndHomeNotNullOrderByBeginAtAsc ("Empty Team","Empty Team","canceled",LocalDateTime.now(),LocalDateTime.now().plusDays(7), PageRequest.of(page-1, PAGE_SIZE));
        List<Match> matches = matchPage.toList();



        List<MatchDto> matchDtos = matches.stream().map((element) -> modelMapper.map(element, MatchDto.class))
                .toList();

        MatchPage result = new MatchPage();
        result.setMatchs(matchDtos);
        result.setTotalPages(matchPage.getTotalPages());

        return result;

    }

    public List<Match> getMatchByTeamId(Integer id){
       return matchRepository.findByTeamId(id);
    }




}
