package com.lgm.backend.dto;


import lombok.Data;

import java.io.Serializable;


@Data
public class BetDto implements Serializable {
    Integer id;
    UserDto userId;
    Integer matchId;
    Integer betTeamId;
    Integer amount;
    Float odd;
    Boolean isFinished;

}