package com.example.dtoex.repository;

import com.example.dtoex.model.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Games, Long> {
    @Override
    List<Games> findAll();
   Optional <Games> findByTitle(String title);
}
