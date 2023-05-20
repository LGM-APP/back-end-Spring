package com.lgm.backend.repository.mainDb;

import com.lgm.backend.model.mainDb.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Integer> {

    Optional<VideoGame> findByName(String name);

}
