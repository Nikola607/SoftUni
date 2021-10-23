package com.example.music.repositories;

import com.example.music.model.entities.Artist;
import com.example.music.model.entities.enums.BandNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findAllByBandNames(BandNames bandNames);
}
