package com.lgm.backend.controller;


import com.lgm.backend.dto.TeamDto;
import com.lgm.backend.dto.TeamPage;
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
    public TeamPage getAllTeam(@PathVariable("page") Integer page){
        return teamService.getallTeamByPage(page);
    }


    @GetMapping("/search")
    public List<TeamDto> searchTeamsByName(@RequestParam(value = "name", required = false,defaultValue = "") String name) {
        return teamService.searchTeamsByName(name).stream().map(team -> modelMapper.map(team, TeamDto.class))
                .collect(Collectors.toList());
    }

}
