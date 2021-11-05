package com.example.path_finder.repository;

import com.example.path_finder.models.enities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findAllByUsernameAndPassword(String username, String password);

    User findAllByUsername(String username);
}
