package com.example.demo.service.impl;

import com.example.demo.model.dto.ProductNameAndPriceDto;
import com.example.demo.model.dto.ProductsSeedDto;
import com.example.demo.model.entity.Products;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductsService;
import com.example.demo.service.UserService;
import com.example.demo.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.constraint.GlobalConstraint.RESOURCES_FILES_PATH;

@Service
public class ProductsServiceImpl implements ProductsService {
    public static final String PRODUCTS_FILE_NAME = "products.json";
    private final UserService userService;
    private final ProductsRepository productsRepository;
    private final CategoryService categoryService;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public ProductsServiceImpl(UserService userService, ProductsRepository productsRepository, CategoryService categoryService, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userService = userService;
        this.productsRepository = productsRepository;
        this.categoryService = categoryService;
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
                .map(productsSeedDto -> {
                   Products products =  modelMapper.map(productsSeedDto, Products.class);
                   products.setSellerId(userService.findRandomUser());
                   products.setBuyerId(userService.findRandomUser());
                   products.setCategories(categoryService.findRandomCategories());

                   return products;
                })
                .forEach(productsRepository::save);

    }

    @Override
    public List<ProductNameAndPriceDto> findAllProductsInRangeOrderByPrice(BigDecimal lower, BigDecimal upper) {
        return productsRepository
                .findProductsByPriceBetweenAndBuyerIdIsNullOrderByPriceDesc(lower, upper)
                .stream()
                .map(products -> {
                    ProductNameAndPriceDto priceDto = modelMapper
                            .map(products, ProductNameAndPriceDto.class);

                    return priceDto;
                }).collect(Collectors.toList());
    }
}
