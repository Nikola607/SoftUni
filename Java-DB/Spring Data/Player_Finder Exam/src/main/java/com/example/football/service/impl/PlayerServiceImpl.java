package com.example.football.service.impl;

import com.example.football.models.entity.Player;
import com.example.football.models.xmldto.PlayerSeedRootDto;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class PlayerServiceImpl implements PlayerService {

    private final StatService statService;
    private final TeamService teamService;
    private final TownService townService;
    private final PlayerRepository playerRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PlayerServiceImpl(StatService statService, TeamService teamService, TownService townService, PlayerRepository playerRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.statService = statService;
        this.teamService = teamService;
        this.townService = townService;
        this.playerRepository = playerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/xml/players.xml"));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile("src/main/resources/files/xml/players.xml", PlayerSeedRootDto.class)
                .getPlayers()
                .stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto)
                            && !IsEmailExists(playerSeedDto.getEmail());

                    sb.append(isValid ? String.format("Successfully imported Player %s %s - %s",
                            playerSeedDto.getFirstName(), playerSeedDto.getLastName(), playerSeedDto.getPosition()) :
                            String.format("Invalid Player"));
                    sb.append(System.lineSeparator());

                    return isValid;
                })
                .map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);

                    player.setTeam(teamService.findByName(playerSeedDto.getTeam().getName()));
                    player.setTown(townService.findByName(playerSeedDto.getTown().getName()));
                    player.setStat(statService.findById(playerSeedDto.getStat().getId()));

                    return player;
                })
                .forEach(playerRepository::save);

        return sb.toString();
    }

    private boolean IsEmailExists(String email) {
        return playerRepository.existsByEmail(email);
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();

        playerRepository.findBestPlayers()
                .stream()
                .forEach(player -> {
                    sb.append(String.format("Player - %s %s\n" +
                                    "\tPosition - %s\n" +
                                    "\tTeam - %s\n" +
                                    "\tStadium - %s\n", player.getFirstName(), player.getLastName(),
                            player.getPosition(), player.getTeam().getName(), player.getTeam().getStadiumName()));

                });
        return sb.toString();
    }
}
