package com.lgm.backend.repository.mainDb;




 import com.lgm.backend.model.mainDb.Match;
 import org.springframework.data.domain.Page;
 import org.springframework.data.domain.Pageable;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.stereotype.Repository;

 import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {


 List<Match> findAllByBeginAtAfterAndTournamentId(LocalDateTime beginAt, Integer tournament_id);


 Page<Match> findAllByStatusNotLikeAndBeginAtAfterAndAwayNotNullOrHomeNotNullOrderByBeginAtAsc(String status, LocalDateTime now, Pageable pageable);

 @Query("SELECT m FROM Match m where m.away.id=:id or m.home.id=:id")
 List<Match> findByTeamId(Integer id);


}
