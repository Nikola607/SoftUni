package com.example.battleships.services;

import com.example.battleships.models.entities.Category;
import com.example.battleships.models.entities.enums.CategoryNamesEnum;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    void initializeCategories();

    Category findByCategoryName(CategoryNamesEnum category);
}
