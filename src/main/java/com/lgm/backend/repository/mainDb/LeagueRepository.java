package com.lgm.backend.repository.mainDb;

import com.lgm.backend.model.backendDb.Role;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.model.mainDb.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<League, Integer> {

    Optional<League> findByVideogameId (Integer videogameId);

}
