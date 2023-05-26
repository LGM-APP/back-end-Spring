package com.lgm.backend.controler;

import com.lgm.backend.security.JwtUtilities;
import com.lgm.backend.security.UserDetailService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class FavoriteController {

    private final JwtUtilities jwtUtilities;

    @GetMapping("/test")
    public String getEmail(@NonNull HttpServletRequest request){
        return jwtUtilities.extractUsername(jwtUtilities.getToken(request));
    }

}
