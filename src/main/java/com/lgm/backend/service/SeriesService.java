package com.lgm.backend.service;

import com.lgm.backend.dto.SeriePage;
import com.lgm.backend.dto.SeriesDto;
import com.lgm.backend.model.mainDb.League;
import com.lgm.backend.model.mainDb.Serie;
import com.lgm.backend.model.mainDb.VideoGame;
import com.lgm.backend.repository.mainDb.LeagueRepository;
import com.lgm.backend.repository.mainDb.SerieRepository;
import com.lgm.backend.repository.mainDb.VideoGameRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeriesService {

    Integer PAGE_SIZE = 20;

    private final SerieRepository serieRepository;
    private final ModelMapper modelMapper;

    public List<Serie> getSeriesByVideoGame(String name){
        List<Serie> series = serieRepository.findAllByVideoGameName(name);
        return series;
    }

    public SeriePage getPageSeriesByVideogame(String videoGame, Integer page){

        Page<Serie> seriePage = serieRepository.findByLeagueId_Videogame_NameOrderByBeginAtDesc(videoGame, PageRequest.of(page-1, PAGE_SIZE));
        List<SeriesDto> series = seriePage.stream().toList().stream().map((element) -> modelMapper.map(element, SeriesDto.class)).toList();

        SeriePage result = new SeriePage();
        result.setSeries(series);
        result.setTotalPages(seriePage.getTotalPages());

        return result;

    }
}
