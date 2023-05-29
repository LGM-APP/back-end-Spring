package com.lgm.backend.service;

import com.lgm.backend.model.backendDb.Bet;
import com.lgm.backend.model.backendDb.User;
import com.lgm.backend.model.mainDb.Match;
import com.lgm.backend.repository.backendDb.BetRepository;
import com.lgm.backend.repository.backendDb.UserRepository;
import com.lgm.backend.repository.mainDb.MatchRepository;
import com.lgm.backend.repository.mainDb.TeamRepository;
import com.lgm.backend.security.JwtUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BetService {

  //  private final PointService pointService;
  //  private final JwtUtilities jwtUtilities;
  //  private final UserService userService;
  //
  //  private final BetRepository betRepository;
  //  private final MatchRepository matchRepository;
  //  private final TeamRepository teamRepository;
  //  private final MatchOpponentRepository matchOpponentRepository;
  //
  //  public Bet addBet(String token, Integer match_id, Integer betTeam, Integer amount){
  //      String email = jwtUtilities.extractUsername(token);
  //
  //      Optional<Match> match = matchRepository.findById(match_id);
  //      Optional<MatchOpponent> matchOpponentOptional = matchOpponentRepository.findByMatchId(match_id);
  //      Optional<User> userOptional = userService.getUser(email);
  //
  //      if (matchOpponentOptional.isEmpty() || userOptional.isEmpty()|| match.isEmpty()){
  //          return null;
  //      }
  //
  //      User user = userOptional.get();
  //
  //      MatchOpponent matchOpponent = matchOpponentOptional.get();
  //      Integer idAway = matchOpponent.getAway().getId();
  //      Integer idHome = matchOpponent.getHome().getId();
  //
  //      if ((!Objects.equals(idAway, betTeam) && !Objects.equals(idHome, betTeam))  || pointService.getPoint(email) < amount || match.get().getStatus().equals("finished")){
  //          return null;
  //      }
  //
  //      Float fl = 2.156F;
  //
  //      return new Bet(user, match_id, betTeam ,amount, fl);
  //  }

    



}
