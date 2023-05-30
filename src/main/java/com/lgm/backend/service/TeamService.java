package com.lgm.backend.service;

import com.lgm.backend.dto.TeamDto;
import com.lgm.backend.dto.TeamPage;
import com.lgm.backend.model.mainDb.Team;
import com.lgm.backend.repository.mainDb.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TeamService{

    int MAX_SUGGESTIONS = 20;
    int PAGE_SIZE = 12;
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    public Optional<Team> getTeam(Integer id){
        return teamRepository.findById(id);
    }

    public TeamPage getallTeamByPage(Integer page){

        Page<Team> teamPage = teamRepository.findAll(PageRequest.of(page, PAGE_SIZE));
        List<Team> teams = teamPage.getContent();

        List<TeamDto> teamsDto = teams.stream().map((element) -> modelMapper.map(element, TeamDto.class))
                .toList();

        TeamPage result = new TeamPage();
        result.setTeams(teamsDto);
        result.setTotalPages(teamPage.getTotalPages());

        return result;
    }

    public List<Team> searchTeamsByName(String name) {
        return teamRepository.findByNameContainingIgnoreCase(name, PageRequest.of(0, MAX_SUGGESTIONS));
    }



}
