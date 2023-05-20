package com.lgm.backend.service;


import com.lgm.backend.model.mainDb.Match;
import com.lgm.backend.model.mainDb.Match;
import com.lgm.backend.repository.mainDb.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    public Iterable<Match> getMatchBySerieId(Integer id){

        return null;
    }

    public Iterable<Match> getAllMatchDontBegin(){


        return  matchRepository.findAllByBeginAtAfter(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
    }


}
