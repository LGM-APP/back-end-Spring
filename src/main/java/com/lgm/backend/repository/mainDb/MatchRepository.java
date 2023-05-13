package com.lgm.backend.repository.mainDb;

import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.model.mainDb.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

}
