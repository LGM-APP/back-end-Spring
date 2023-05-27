package com.lgm.backend.repository.mainDb;




 import com.lgm.backend.model.mainDb.Match;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.stereotype.Repository;


 import java.time.LocalDateTime;
 import java.util.Date;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

 List<Match> findAllByBeginAtAfterAndTournamentId(LocalDateTime beginAt, Integer tournament_id);

 List<Match> findAllByBeginAtAfterAndBeginAtBeforeOrderByBeginAtAsc(LocalDateTime now, LocalDateTime oneWeekLater);

 @Query("SELECT m FROM Match m JOIN MatchOpponent mo ON m.id = mo.match.id WHERE mo.home.id = 128268 OR mo.away.id = 128268 order by m.beginAt desc ")
 List<Match> findByHomeIdOrAwayId(Integer id);

}
