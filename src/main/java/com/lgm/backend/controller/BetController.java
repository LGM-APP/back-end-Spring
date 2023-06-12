package com.lgm.backend.controller;

import com.lgm.backend.dto.BetDto;
import com.lgm.backend.dto.BetPage;
import com.lgm.backend.security.JwtUtilities;
import com.lgm.backend.service.BetService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bet")
@RequiredArgsConstructor
public class BetController {

    private final BetService betService;
    private  final JwtUtilities jwtUtilities ;
    private final ModelMapper modelMapper;

    @PostMapping("/add")
    public BetDto addBet(@NonNull HttpServletRequest request,
                        @RequestParam(value = "matchID") Integer match_id,
                        @RequestParam(value = "betTeamID") Integer betTeam,
                        @RequestParam(value = "amount") Float amount){

        String token = jwtUtilities.getToken(request);
        return betService.addBet(token, match_id, betTeam, amount);
    }

    @GetMapping("/get/{page}")
    public BetPage getBet(@NonNull HttpServletRequest request, @PathVariable(value = "page") Integer page){
        String token = jwtUtilities.getToken(request);
        return betService.getAllBetByPage(page,token);
    }

}
