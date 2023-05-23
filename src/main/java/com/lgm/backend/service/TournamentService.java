package com.lgm.backend.service;

import com.lgm.backend.model.mainDb.Serie;
import com.lgm.backend.model.mainDb.Tournament;
import com.lgm.backend.repository.mainDb.TournamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TournamentService {

    private  final TournamentRepository tournamentRepository;

    public List<Tournament> getTounamentsByVideoGame(String name){


        List<Tournament> series = tournamentRepository.findAllTournamentsByVideoGameName(name);

        return  series;

    }

}
