package com.example.music.repositories;

import com.example.music.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findAllByUsernameAndPassword(String username, String password);
    Optional<User> findById(Long id);
}
