package com.lgm.backend.repository.backendDb;


import com.lgm.backend.dto.UserDto;
import com.lgm.backend.model.backendDb.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id NOT IN (1, 2) ORDER BY u.point DESC")
    Page<User> findAllOrderByPointDesc(Pageable pageable);

}
