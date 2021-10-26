package com.example.battleships.services.impl;

import com.example.battleships.models.entities.Category;
import com.example.battleships.models.entities.enums.CategoryNamesEnum;
import com.example.battleships.repositories.CategoryRepository;
import com.example.battleships.services.CategoryService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initializeCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNamesEnum.values())
                .forEach(categoryNamesEnum -> {
                    Category category = new Category();
                    category.setName(categoryNamesEnum);

                    switch (categoryNamesEnum) {
                        case CARGO:
                            category.setDescription("It's very big boi for moving stuff to different places.");
                            break;
                        case BATTLE:
                            category.setDescription("It's very powerful boi for destroying other ships.");
                            break;
                        case PATROL:
                            category.setDescription("It's just a patrol boat...");
                    }

                    categoryRepository.save(category);
                });
    }

    @Override
    public Category findByCategoryName(CategoryNamesEnum category) {

        return categoryRepository.findAllByName(category)
                .orElse(null);
    }
}
