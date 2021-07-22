package com.example.demo.service.impl;

import com.example.demo.constraint.GlobalConstraint;
import com.example.demo.model.dto.ProductsSeedDto;
import com.example.demo.model.entity.Products;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductsService;
import com.example.demo.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.demo.constraint.GlobalConstraint.RESOURCES_FILES_PATH;

@Service
public class ProductsServiceImpl implements ProductsService {
    public static final String PRODUCTS_FILE_NAME = "products.json";
    private ProductsRepository productsRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public ProductsServiceImpl(ProductsRepository productsRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.productsRepository = productsRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedProducts() throws IOException {
        if(productsRepository.count() > 0){
            return;
        }

        String fileContent = Files
                .readString(Path.of(RESOURCES_FILES_PATH + PRODUCTS_FILE_NAME));

        ProductsSeedDto[] productsSeedDtos = gson
                .fromJson(fileContent, ProductsSeedDto[].class);

        Arrays.stream(productsSeedDtos)
                .filter(validationUtil::isValid)
                .map(productsSeedDto -> modelMapper.map(productsSeedDto, Products.class))
                .forEach(productsRepository::save);

    }
}
