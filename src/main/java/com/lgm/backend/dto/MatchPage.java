package com.lgm.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class MatchPage {
    List<MatchDto> matchs;
    private int totalPages;

}
