package com.lgm.backend.repository.mainDb;

import com.lgm.backend.model.mainDb.MatchOpponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchOpponentRepository extends JpaRepository<MatchOpponent, Integer> {
}
