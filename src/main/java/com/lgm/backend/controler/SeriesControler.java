package com.lgm.backend.controler;

import com.lgm.backend.model.mainDb.Serie;
import com.lgm.backend.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SeriesControler {

    private final SeriesService seriesService;


    @GetMapping("/{videogame}")
    @ResponseBody
    Iterable<Serie> getbyName(@PathVariable("videogame") String videogame){
        return seriesService.getSeriesByVideoGame(videogame);
    }

}
