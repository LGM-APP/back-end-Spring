package com.lgm.backend.repository.backendDb;

import com.lgm.backend.model.backendDb.FavoriteTeam;
import com.lgm.backend.model.backendDb.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteTeamRepository extends JpaRepository<FavoriteTeam, Integer> {
}
