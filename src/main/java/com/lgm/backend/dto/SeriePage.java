package com.lgm.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class SeriePage {

    List<SeriesDto> series;
    private int totalPages;
}
