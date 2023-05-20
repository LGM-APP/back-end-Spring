package com.lgm.backend.controler;


import com.lgm.backend.model.mainDb.Match;
import com.lgm.backend.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    @GetMapping("/tournament/{serie}")
    @ResponseBody
    public Iterable<Match> getMatchBySerieId(@PathVariable("serie") Integer id){

        return matchService.getAllMatchDontBegin();

    }


}
