package com.example.demo.service;

import com.example.demo.model.dto.CategorySeedDto;
import com.example.demo.model.entity.Categories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories);

    Set<Categories> getRandomCategories();
}
