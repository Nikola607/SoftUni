package com.example.demo;

import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductsService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductsService productsService;

    public CommandLineRunner(CategoryService categoryService, UserService userService, ProductsService productsService) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productsService = productsService;
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();

    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productsService.seedProducts();
    }
}
