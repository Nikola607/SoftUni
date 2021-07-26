package com.example.demo.service.impl;

import com.example.demo.model.dto.CategorySeedDto;
import com.example.demo.model.entity.Categories;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.demo.constraint.GlobalConstraint.RESOURCES_FILES_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORIES_FILE_NAME = "categories.json";

    private CategoryRepository categoryRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {
        if(categoryRepository.count() > 0){
            return;
        }


        String fileContent = Files
                .readString(Path.of(RESOURCES_FILES_PATH + CATEGORIES_FILE_NAME));

        CategorySeedDto[] categorySeedDtos = gson
                .fromJson(fileContent, CategorySeedDto[].class);

        Arrays.stream(categorySeedDtos)
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Categories.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Categories> findRandomCategories() {
        Set<Categories> categories = new HashSet<>();
        int categoryCount = ThreadLocalRandom
                .current().nextInt(1, 3);

        long categoriesCount = categoryRepository.count();

        for(int i = 0; i < categoryCount; i++){
            long randomId = ThreadLocalRandom
                    .current().nextLong(1, categoriesCount + 1);

            categories.add(categoryRepository.findById(randomId)
            .orElse(null));
        }

        return categories;
    }
}
