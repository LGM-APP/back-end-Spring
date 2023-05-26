package com.lgm.backend.service;

import com.lgm.backend.model.mainDb.Team;
import com.lgm.backend.repository.mainDb.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeamService{

    private final TeamRepository teamRepository;

    public Optional<Team> getTeam(Integer id){
        return teamRepository.findById(id);
    }

}
