package com.lgm.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lgm.backend.model.mainDb.Team;
import com.lgm.backend.model.mainDb.Tournament;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MatchDto {

    private Integer id;
    private String name;
    private String matchType;
    private Integer numberOfGames;
    private TournamentDto tournament;
    private String status;
    private Boolean draw;
    private TeamDto winner;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime scheduledAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endAt;
    private TeamDto away;
    private TeamDto home;
    private Float homeOdd;
    private Float awayOdd;

}
