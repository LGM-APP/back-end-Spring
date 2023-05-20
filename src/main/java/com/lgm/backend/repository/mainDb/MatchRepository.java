package com.lgm.backend.repository.mainDb;




 import com.lgm.backend.model.mainDb.Match;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;


 import java.time.LocalDateTime;
 import java.util.Date;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    List<Match> findAllByBeginAtAfter(LocalDateTime beginAt);


}
