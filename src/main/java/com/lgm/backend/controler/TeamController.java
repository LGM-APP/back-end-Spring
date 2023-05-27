package com.lgm.backend.controler;


import com.lgm.backend.dto.TeamDto;
import com.lgm.backend.service.MatchService;
import com.lgm.backend.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    @Autowired
    private ModelMapper modelMapper;

    private final TeamService teamService;

    @GetMapping("/page/{page}")
    @ResponseBody
    public List<TeamDto> getAllTeam(@PathVariable("page") Integer page){
        return teamService.getallTeamByPage(page).stream().map(team -> modelMapper.map(team, TeamDto.class))
                .collect(Collectors.toList());
    }


    @GetMapping("/teams/search")
    public List<TeamDto> searchTeamsByName(@RequestParam("name") String name) {
        return teamService.searchTeamsByName(name).stream().map(team -> modelMapper.map(team, TeamDto.class))
                .collect(Collectors.toList());
    }

}
