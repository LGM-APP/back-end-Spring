package com.lgm.backend.service;

import com.lgm.backend.repository.mainDb.LeagueRepository;
import com.lgm.backend.repository.mainDb.SerieRepository;
import com.lgm.backend.repository.mainDb.TournamentRepository;
import com.lgm.backend.repository.mainDb.VideoGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TournamentService {

    TournamentRepository tournamentRepository;
    SerieRepository serieRepository;
    LeagueRepository leagueRepository;
    VideoGameRepository videoGameRepository;

}
