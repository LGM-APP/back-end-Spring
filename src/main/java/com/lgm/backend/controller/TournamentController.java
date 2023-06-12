package com.lgm.backend.controller;


import com.lgm.backend.dto.TournamentDto;
import com.lgm.backend.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tournaments")
@RequiredArgsConstructor
public class TournamentController {
    @Autowired
    private ModelMapper modelMapper;

    private final TournamentService tournamentService;

    @GetMapping("/series/{id}")
    @ResponseBody
    List<TournamentDto> getbyName(@PathVariable("id") Integer id){
        return tournamentService.getTounamentsBySeriesId(id).stream().map(tournament -> modelMapper.map(tournament, TournamentDto.class))
                .collect(Collectors.toList());
    }


}
