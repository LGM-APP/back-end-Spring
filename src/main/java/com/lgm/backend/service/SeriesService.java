package com.lgm.backend.service;

import com.lgm.backend.model.mainDb.League;
import com.lgm.backend.model.mainDb.Serie;
import com.lgm.backend.model.mainDb.VideoGame;
import com.lgm.backend.repository.mainDb.LeagueRepository;
import com.lgm.backend.repository.mainDb.SerieRepository;
import com.lgm.backend.repository.mainDb.VideoGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeriesService {

    private final SerieRepository serieRepository;
    private final LeagueRepository leagueRepository;
    private final VideoGameRepository videoGameRepository;

    public Iterable<Serie> getSeriesByVideoGame(String name){

        Optional<VideoGame> videoGame = videoGameRepository.findByName(name);


        Iterable<League> leagueIterable = leagueRepository.findAllByVideogame(videoGame.orElse(null));


        List<Serie> series= new ArrayList<>();


        leagueIterable.forEach(league -> {
            series.addAll(serieRepository.findAllByLeagueId(league));
        });

        return series;


    }

}
