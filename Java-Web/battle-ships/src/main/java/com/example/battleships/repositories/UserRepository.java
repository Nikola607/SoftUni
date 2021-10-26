package com.example.battleships.repositories;

import com.example.battleships.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findAllByUsernameAndPassword(String username, String password);
    Optional<User> findAllById(Long id);
}
