package com.lgm.backend.dto;


import com.lgm.backend.model.mainDb.Team;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TournamentDto {

    private Integer id;

    private String name;

    private SeriesDto serie;

    private Team winner;

}
