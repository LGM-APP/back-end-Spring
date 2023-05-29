package com.lgm.backend.service;



import com.lgm.backend.model.mainDb.Match;
import com.lgm.backend.repository.mainDb.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    public List<Match> getMatchByTournamentId(Integer id){
        return matchRepository.findAllByBeginAtAfterAndTournamentId(LocalDateTime.now(),id);
    }

    public List<Match> getAllMatchDontBegin(){
        return  matchRepository.findAllByStatusNotLikeAndBeginAtAfterOrderByBeginAtAsc("canceled",LocalDateTime.now());
    }

    public List<Match> getMatchByTeamId(Integer id){
       return matchRepository.findByTeamId(id);
    }




}
