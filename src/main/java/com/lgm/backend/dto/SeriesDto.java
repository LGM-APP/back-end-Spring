package com.lgm.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lgm.backend.model.mainDb.League;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class SeriesDto {

    private Integer id;

    private LeagueDto leagueId;

    private String fullName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endAt;

}
