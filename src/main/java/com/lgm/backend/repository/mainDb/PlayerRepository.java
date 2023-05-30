package com.lgm.backend.repository.mainDb;

import com.lgm.backend.model.mainDb.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> getPlayerByTeam_Id(Integer teamId);

}
