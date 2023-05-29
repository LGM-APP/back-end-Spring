package com.lgm.backend.repository.backendDb;

import com.lgm.backend.model.backendDb.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetRepository extends JpaRepository<Bet, Integer> {
    boolean existsByMatchIdAndUserId_Email(Integer matchId, String email);
    boolean existsByMatchId(Integer matchId);
}