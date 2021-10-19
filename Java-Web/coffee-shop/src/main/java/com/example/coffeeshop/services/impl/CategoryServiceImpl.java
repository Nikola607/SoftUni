package com.example.coffeeshop.services.impl;

import com.example.coffeeshop.model.entities.Category;
import com.example.coffeeshop.model.entities.enums.CategoryNameEnum;
import com.example.coffeeshop.repositories.CategoryRepository;
import com.example.coffeeshop.services.CategoryService;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                            Category category = new Category();
                            category.setName(categoryNameEnum);

                            switch (categoryNameEnum) {
                                case CAKE:
                                    category.setNeededTime(10);
                                    break;
                                case DRINK:
                                    category.setNeededTime(1);
                                    break;
                                case COFFEE:
                                    category.setNeededTime(2);
                                    break;
                                case OTHER:
                                    category.setNeededTime(5);
                                    break;
                            }

                            categoryRepository.save(category);
                        }
                );
    }
}
