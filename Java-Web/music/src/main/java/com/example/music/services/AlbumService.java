package com.example.music.services;

import com.example.music.model.entities.Artist;
import com.example.music.model.service.AlbumServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface AlbumService {
    AlbumServiceModel addAlbum(AlbumServiceModel map);
}
