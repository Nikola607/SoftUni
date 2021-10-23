package com.example.music.services;

import com.example.music.model.entities.Artist;
import com.example.music.model.entities.enums.BandNames;
import com.example.music.model.entities.enums.Genre;
import org.springframework.stereotype.Service;

@Service
public interface ArtistService {
    void initArtists();

    Artist findByArtistName(BandNames bandNames);
}
