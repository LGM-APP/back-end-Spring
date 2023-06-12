package com.lgm.backend.controller;


import com.lgm.backend.dto.MatchDto;
import com.lgm.backend.dto.MatchPage;
import com.lgm.backend.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/matchs")
@RequiredArgsConstructor
public class MatchController {

    @Autowired
    private ModelMapper modelMapper;

    private final MatchService matchService;

    @GetMapping("/{page}")
    @ResponseBody
    public MatchPage getAllMatch(@PathVariable("page") Integer page){
            return matchService.getAllMatchDontBegin(page);
    }

    @GetMapping("/tournament/{id}")
    @ResponseBody
    public Iterable<MatchDto> getMatchByTournamentId(@PathVariable("id") Integer id){
        return matchService.getMatchByTournamentId(id).stream().map(match -> modelMapper.map(match, MatchDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/team/{id}")
    @ResponseBody
    public Iterable<MatchDto> getMatchByTeamId(@PathVariable("id") Integer id){
        return matchService.getMatchByTeamId(id).stream().map(match -> modelMapper.map(match, MatchDto.class))
                .collect(Collectors.toList());
    }


}
