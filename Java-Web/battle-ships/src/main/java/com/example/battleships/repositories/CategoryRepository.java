package com.example.battleships.repositories;

import com.example.battleships.models.entities.Category;
import com.example.battleships.models.entities.enums.CategoryNamesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findAllByName(CategoryNamesEnum name);
}
