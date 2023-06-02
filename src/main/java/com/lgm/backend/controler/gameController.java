package com.lgm.backend.controler;

import com.lgm.backend.security.JwtUtilities;
import com.lgm.backend.service.PointService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class gameController {

    private final PointService pointService;
    private final JwtUtilities jwtUtilities;

    @PostMapping("/addPoint/{point}")
    public void addPoint(@NonNull HttpServletRequest request, @PathVariable("point")Float point){
        pointService.add(point, jwtUtilities.extractUsername(jwtUtilities.getToken(request)));
    }

}
