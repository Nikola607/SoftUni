package com.example.dtoex.service;

import com.example.dtoex.model.dto.GameAddDto;

import java.math.BigDecimal;
import java.util.List;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(Long id, BigDecimal price, Double size);

    void deleteGame(long id);

    List<String> allGames();

    void detailsGame(String title);

}
