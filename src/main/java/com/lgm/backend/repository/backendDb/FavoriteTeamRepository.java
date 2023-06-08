package com.lgm.backend.repository.backendDb;

import com.lgm.backend.model.backendDb.FavoriteTeam;
import com.lgm.backend.model.backendDb.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteTeamRepository extends JpaRepository<FavoriteTeam, Integer> {
    boolean existsByIdTeam(Integer idTeam);
    Integer deleteByUserIdAndIdTeam(User userId, Integer idTeam);
    Optional<FavoriteTeam> deleteByIdTeamAndUserId_Id(Integer idTeam, Integer id);
    List<FavoriteTeam> findByUserId_Id(Integer id);


}
