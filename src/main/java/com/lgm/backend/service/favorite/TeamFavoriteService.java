package com.lgm.backend.service.favorite;

import com.lgm.backend.model.backendDb.FavoriteTeam;
import com.lgm.backend.repository.backendDb.FavoriteTeamRepository;
import com.lgm.backend.repository.mainDb.TeamRepository;
import com.lgm.backend.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TeamFavoriteService implements IfavoriteService<FavoriteTeam>{

    private final FavoriteTeamRepository favoriteTeamRepository;
    private final TeamService teamService;

    @Override
    public List<FavoriteTeam> getAll(Integer userId, Integer elementId) {
        return null;
    }

    @Override
    public FavoriteTeam remove(Integer userId, Integer elementId) {
        return null;
    }

    @Override
    public List<FavoriteTeam> removeAll(Integer userId, List<Integer> elementsId) {
        return null;
    }

    @Override
    public FavoriteTeam add(Integer userId, Integer elementId) {


        if (!teamService.getTeam(elementId).isPresent()){
            return null;
        }



        return null;

    }

    @Override
    public FavoriteTeam addAll(Integer userId, List<Integer> elementsId) {
        return null;
    }
}
