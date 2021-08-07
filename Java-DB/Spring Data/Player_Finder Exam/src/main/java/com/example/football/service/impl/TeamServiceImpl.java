package com.example.football.service.impl;

import com.example.football.models.jsondto.TeamSeedDto;
import com.example.football.models.entity.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Component
public class TeamServiceImpl implements TeamService {

    private final TownService townService;
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public TeamServiceImpl(TownService townService, TeamRepository teamRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.townService = townService;
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/json/teams.json"));
    }

    @Override
    public String importTeams() throws IOException {
        StringBuilder sb = new StringBuilder();
        TeamSeedDto[] teamSeedDtos = gson.fromJson(readTeamsFileContent(), TeamSeedDto[].class);

        Arrays.stream(teamSeedDtos)
                .filter(teamSeedDto -> {
                    boolean isValid = validationUtil.isValid(teamSeedDto)
                            && !isTeamExistsByName(teamSeedDto.getName());

                    sb.append(isValid ? String.format("Successfully imported Team %s - %d",
                            teamSeedDto.getName(), teamSeedDto.getFanBase()) : String.format("Invalid Team"));
                    sb.append(System.lineSeparator());

                    return isValid;
                })
                .map(teamSeedDto -> {
                    Team map = modelMapper.map(teamSeedDto, Team.class);

                    map.setTown(townService.findByName(teamSeedDto.getTownName()));

                    return map;
                })
                .forEach(teamRepository::save);
        return sb.toString();
    }

    @Override
    public Team findByName(String name) {
        return teamRepository.findByName(name);
    }

    private boolean isTeamExistsByName(String name) {
        return teamRepository.existsByName(name);
    }
}
