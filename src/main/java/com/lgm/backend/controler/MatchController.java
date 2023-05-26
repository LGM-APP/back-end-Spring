package com.lgm.backend.controler;


import com.lgm.backend.dto.MatchDto;
import com.lgm.backend.dto.SeriesDto;
import com.lgm.backend.model.mainDb.Match;
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

    @GetMapping("/all")
    @ResponseBody
    public Iterable<MatchDto> getMatchBySerieId(){
            return matchService.getAllMatchDontBegin().stream().map(match -> modelMapper.map(match, MatchDto.class))
                    .collect(Collectors.toList());
    }

    @GetMapping("/tournament/{id}")
    @ResponseBody
    public Iterable<MatchDto> getMatchBySerieId(@PathVariable("id") Integer id){
        return matchService.getMatchByTournamentId(id).stream().map(match -> modelMapper.map(match, MatchDto.class))
                .collect(Collectors.toList());
    }
}
