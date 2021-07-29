package com.example.demo.service.impl;

import com.example.demo.model.dto.CategorySeedDto;
import com.example.demo.model.entity.Categories;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
        if(categoryRepository.count() == 0) {
            categories.stream()
                    .filter(validationUtil::isValid)
                    .map(categorySeedDto -> modelMapper.map(categorySeedDto, Categories.class))
                    .forEach(categoryRepository::save);
        }
    }

    @Override
    public Set<Categories> getRandomCategories() {
        Set<Categories> categories = new HashSet<>();
        long categoriesCount = categoryRepository.count();

        for(int i = 0; i < 2; i++){
            long randomId = ThreadLocalRandom.current().nextLong(1, categoriesCount + 1);

            categories.add(categoryRepository.findById(randomId).orElse(null));
        }
        return categories;
    }
}
