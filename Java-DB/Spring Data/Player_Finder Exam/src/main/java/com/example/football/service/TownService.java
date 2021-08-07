package com.example.football.service;


import com.example.football.models.entity.Town;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public interface TownService {

    boolean areImported();

    String readTownsFileContent() throws IOException;
	
	String importTowns() throws IOException;

    boolean isTownExistsByName(String name);

    Town findByName(String town);

}
