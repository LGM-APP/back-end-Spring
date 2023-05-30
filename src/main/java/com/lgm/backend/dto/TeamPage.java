package com.lgm.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamPage {
    private List<TeamDto> teams;
    private int totalPages;
}
