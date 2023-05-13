package com.lgm.backend.repository.mainDb;

import com.lgm.backend.model.mainDb.MatchStream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchStreamRepository extends JpaRepository<MatchStream, Integer> {
}
