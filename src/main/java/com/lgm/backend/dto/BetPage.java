package com.lgm.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class BetPage {
    List<BetDto> series;
    private int totalPages;
}
