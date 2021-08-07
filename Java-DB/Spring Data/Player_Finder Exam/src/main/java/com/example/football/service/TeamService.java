package com.example.football.service;

import com.example.football.models.entity.Team;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface TeamService {
    boolean areImported() throws IOException;

    String readTeamsFileContent() throws IOException;

    String importTeams() throws IOException;

    Team findByName(String name);

}
