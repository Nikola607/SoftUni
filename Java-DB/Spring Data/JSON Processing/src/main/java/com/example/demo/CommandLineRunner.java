package com.example.demo;

import com.example.demo.model.dto.ProductNameAndPriceDto;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductsService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductsService productsService;
    private final BufferedReader bufferedReader;

    public CommandLineRunner(CategoryService categoryService, UserService userService, ProductsService productsService, BufferedReader bufferedReader) {   
        this.categoryService = categoryService;
        this.userService = userService;
        this.productsService = productsService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        int exNum = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter exercise number: ");

        switch (exNum){
            case 1 -> productsInRange();
        }
    }

    private void productsInRange() {
        List<ProductNameAndPriceDto> productList = productsService
                .findAllProductsInRangeOrderByPrice(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productsService.seedProducts();
    }
}
