package com.lgm.backend.repository.mainDb;


import com.lgm.backend.model.mainDb.Serie;
import com.lgm.backend.model.mainDb.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    List<Tournament> findTournamentBySerieId(Integer id);

}
