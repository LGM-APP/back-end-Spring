package com.lgm.backend.service;

import com.lgm.backend.model.mainDb.Player;
import com.lgm.backend.repository.mainDb.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public List<Player> getPlayerByTeamId(Integer teamId){
        return playerRepository.getPlayerByTeam_Id(teamId);
    }


}
