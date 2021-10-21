package com.example.coffeeshop.services;

import com.example.coffeeshop.model.entities.Category;
import com.example.coffeeshop.model.entities.enums.CategoryNameEnum;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    void initCategories();

    Category findByCategoryName(CategoryNameEnum category);
}
