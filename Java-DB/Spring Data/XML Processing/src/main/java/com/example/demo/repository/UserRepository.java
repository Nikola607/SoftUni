package com.example.demo.repository;

import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM users u " +
            "JOIN products p ON u.id = p.sellerId.id " +
            "WHERE p.buyerId.id IS NOT NULL " +
            "GROUP BY u.id " +
            "HAVING COUNT (p.id) > 0")
    List<User> findAllUsersWithMoreThatOneSoldProduct();
}
