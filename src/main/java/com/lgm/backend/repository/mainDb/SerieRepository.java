package com.lgm.backend.repository.mainDb;


import com.lgm.backend.model.mainDb.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {


}
