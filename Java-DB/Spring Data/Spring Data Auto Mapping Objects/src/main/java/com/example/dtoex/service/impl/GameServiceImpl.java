package com.example.dtoex.service.impl;

import com.example.dtoex.model.dto.GameAddDto;
import com.example.dtoex.model.entity.Games;
import com.example.dtoex.repository.GameRepository;
import com.example.dtoex.service.GameService;
import com.example.dtoex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.violation(gameAddDto);

        if(!violations.isEmpty()){
            violations.stream()
                    .map(violation -> violation.getMessage())
                    .forEach(System.out::println);
            return;
        }

        Games game = modelMapper.map(gameAddDto, Games.class);

        gameRepository.save(game);
        System.out.println("Added game " + gameAddDto.getTitle());
    }

    @Override
    public void editGame(Long id, BigDecimal price, Double size) {
    }

    @Override
    public void deleteGame(long id) {
        Games games = gameRepository.findById(id)
                .orElse(null);

        if(games == null){
            System.out.println("No game found with such id");
            return;
        }

        gameRepository.delete(games);
        System.out.println(games.getTitle() + " deleted.");
    }

    @Override
    public List<String> allGames() {
       return gameRepository.findAll()
                .stream().map(games -> String.format("%s %.2f",
                games.getTitle(), games.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public void detailsGame(String title) {
        Games games = gameRepository.findByTitle(title)
                .orElse(null);

        if(games == null){
            System.out.println("No such game found");
            return;
        }

        System.out.printf("Title: %s \n Price: %.2f \n Description: %s \n Release date: %s \n", games.getTitle(),
                games.getPrice(), games.getDescription(), games.getDate());
    }
}
