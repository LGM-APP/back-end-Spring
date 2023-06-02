package com.lgm.backend.dto;

import com.lgm.backend.model.mainDb.VideoGame;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class LeagueDto {

    private Integer id;

    private String imageUrl;

    private String name;

    private VideoGameDto videoGame;
}
