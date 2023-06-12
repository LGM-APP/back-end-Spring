package com.lgm.backend.controller;

import com.lgm.backend.dto.PlayerDto;
import com.lgm.backend.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final ModelMapper modelMapper;
    private final PlayerService playerService;

    @GetMapping("/{idTeam}")
    private List<PlayerDto> getPlayer(@PathVariable("idTeam") Integer idTeam){
        return playerService.getPlayerByTeamId(idTeam).stream().map((element) -> modelMapper.map(element, PlayerDto.class))
                .collect(Collectors.toList());
    }
}
