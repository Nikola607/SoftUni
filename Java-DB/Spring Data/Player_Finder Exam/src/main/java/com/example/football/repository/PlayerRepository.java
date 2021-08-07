package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByEmail(String email);


    @Query("SELECT DISTINCT p FROM players p " +
            "ORDER BY p.stat.shooting DESC, p.stat.passing DESC, " +
            "p.stat.endurance DESC, p.lastName")
    List<Player> findBestPlayers();
}
