package com.lgm.backend.repository.mainDb;


import com.lgm.backend.model.mainDb.League;
import com.lgm.backend.model.mainDb.Serie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {
    Page<Serie> findByLeagueId_Videogame_NameOrderByBeginAtDesc(String name, Pageable pageable);

    List<Serie> findAllByLeagueId (League leagueId);

    @Query("SELECT s FROM Serie s INNER JOIN s.leagueId l INNER JOIN l.videogame vg WHERE vg.name = :name AND current timestamp between s.beginAt and s.endAt")
    List<Serie> findAllByVideoGameName(@Param("name") String name);

}
