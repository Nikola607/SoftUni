package com.example.music.services.impl;

import com.example.music.model.entities.Album;
import com.example.music.model.service.AlbumServiceModel;
import com.example.music.repositories.AlbumRepository;
import com.example.music.security.CurrentUser;
import com.example.music.services.AlbumService;
import com.example.music.services.ArtistService;
import com.example.music.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistService artistService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistService artistService, CurrentUser currentUser, UserService userService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistService = artistService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public AlbumServiceModel addAlbum(AlbumServiceModel albumServiceModel) {
        Album album = modelMapper.map(albumServiceModel, Album.class);
        album.setArtist(artistService.findByArtistName(albumServiceModel.getArtist()));
        album.setUser(userService.findById(currentUser.getId()));

        albumRepository.save(album);

        return modelMapper.map(album, AlbumServiceModel.class);
    }
}
