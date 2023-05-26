package com.lgm.backend.repository.backendDb;

import com.lgm.backend.model.backendDb.FavoriteTournaments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteTournamentRepository extends JpaRepository<FavoriteTournaments, Integer> {
}
