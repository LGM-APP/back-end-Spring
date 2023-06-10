package com.lgm.backend.controler;

import com.lgm.backend.dto.FavoriteTeamDto;
import com.lgm.backend.model.backendDb.FavoriteTeam;
import com.lgm.backend.security.JwtUtilities;
import com.lgm.backend.service.favorite.FavoriteTeamService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritesTeam")
@RequiredArgsConstructor
public class FavoriteTeamController {

    private final JwtUtilities jwtUtilities;
    private final FavoriteTeamService favoriteTeamService;

    @PostMapping("/add")
    public ResponseEntity<List<FavoriteTeamDto>> addTeamToFavorite(@RequestBody List<FavoriteTeamDto> favoriteTeamDtoList, @NonNull HttpServletRequest request){
        String token = jwtUtilities.getToken(request);
        return new ResponseEntity<>(favoriteTeamService.addAll(token,favoriteTeamDtoList), HttpStatus.ACCEPTED);
    }

    @PostMapping("/delete")
    public ResponseEntity<Integer> removETeamToFavorite(@RequestBody List<FavoriteTeamDto> favoriteTeamDtoList, @NonNull HttpServletRequest request){
        String token = jwtUtilities.getToken(request);
        return new ResponseEntity<>(favoriteTeamService.removeAll(token,favoriteTeamDtoList), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get")
    public List<FavoriteTeamDto> getAllFavorite(@NonNull HttpServletRequest request){
        String token = jwtUtilities.getToken(request);
        return favoriteTeamService.getAll(token);
    }

}