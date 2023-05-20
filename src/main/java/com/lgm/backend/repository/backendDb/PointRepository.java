package com.lgm.backend.repository.backendDb;

import com.lgm.backend.model.backendDb.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer> {

}
