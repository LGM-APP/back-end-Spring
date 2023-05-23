package com.lgm.backend.service;

import com.lgm.backend.model.mainDb.League;
import com.lgm.backend.model.mainDb.Serie;
import com.lgm.backend.model.mainDb.VideoGame;
import com.lgm.backend.repository.mainDb.LeagueRepository;
import com.lgm.backend.repository.mainDb.SerieRepository;
import com.lgm.backend.repository.mainDb.VideoGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeriesService {

    private final SerieRepository serieRepository;
    public List<Serie> getSeriesByVideoGame(String name){
        List<Serie> series = serieRepository.findAllByVideoGameName(name);
        return series;
    }
}
