package com.lgm.backend.repository.mainDb;


import com.lgm.backend.model.mainDb.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
