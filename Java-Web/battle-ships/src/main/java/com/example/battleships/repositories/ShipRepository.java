package com.example.battleships.repositories;

import com.example.battleships.models.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

 //   @Query("SELECT s FROM ships As s WHERE s.user.id = s.id")
    List<Ship> findAllById(Long id);
}
