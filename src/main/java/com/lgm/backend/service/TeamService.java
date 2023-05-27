package com.lgm.backend.service;

import com.lgm.backend.model.mainDb.Team;
import com.lgm.backend.repository.mainDb.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeamService{

    int MAX_SUGGESTIONS = 20;
    private final TeamRepository teamRepository;

    public Optional<Team> getTeam(Integer id){
        return teamRepository.findById(id);
    }

    public Page<Team> getallTeamByPage(Integer page){
        return  teamRepository.findAll(PageRequest.of(page,10));
    }

    public List<Team> searchTeamsByName(String name) {
        return teamRepository.findByNameContainingIgnoreCase(name, PageRequest.of(0, MAX_SUGGESTIONS));
    }



}
