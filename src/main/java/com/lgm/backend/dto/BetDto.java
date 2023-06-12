package com.lgm.backend.dto;


import com.lgm.backend.model.mainDb.Match;
import com.lgm.backend.model.mainDb.Team;
import lombok.Data;

import java.io.Serializable;


@Data
public class BetDto implements Serializable {

    Integer id;
    MatchDto matchId;
    TeamDto betTeamId;
    Float amount;
    Float odd;
    Boolean isFinished;
    Integer WinnerId;

}