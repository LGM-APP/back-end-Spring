package com.lgm.backend.repository.mainDb;

import com.lgm.backend.model.mainDb.MatchGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchGameRepository extends JpaRepository<MatchGame, Integer> {
}
