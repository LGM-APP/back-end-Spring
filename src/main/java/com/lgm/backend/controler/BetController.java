package com.lgm.backend.controler;

import com.lgm.backend.dto.BetDto;
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
    public BetDto getEmail(@NonNull HttpServletRequest request,
                        @RequestParam(value = "matchID") Integer match_id,
                        @RequestParam(value = "betTeamID") Integer betTeam,
                        @RequestParam(value = "amount") Float amount){

        String token = jwtUtilities.getToken(request);
        return modelMapper.map(betService.addBet(token, match_id, betTeam, amount), BetDto.class);
    }

}
