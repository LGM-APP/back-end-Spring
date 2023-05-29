package com.lgm.backend.dto;

import com.lgm.backend.dto.UserDto;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;


@Data
public class BetDto implements Serializable {
    Integer id;
    UserDto userId;
    Integer matchId;
    Integer betTeamId;
    Integer amount;
    Float odd;
}