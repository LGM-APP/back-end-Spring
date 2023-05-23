package com.lgm.backend.repository.backendDb;

import com.lgm.backend.model.backendDb.Favorite;
import com.lgm.backend.model.backendDb.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteReposotory extends JpaRepository<Favorite,Integer> {
    List<Favorite> findAllByUserId(User userId);
}
