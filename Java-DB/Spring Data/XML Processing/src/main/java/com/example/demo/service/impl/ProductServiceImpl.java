package com.example.demo.service.impl;

import com.example.demo.model.dto.ProductSeedDto;
import com.example.demo.model.entity.Products;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import com.example.demo.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        if(productRepository.count() == 0){
            products.stream()
                    .filter(validationUtil::isValid)
                    .map(productSeedDto -> {
                        Products product = modelMapper.map(productSeedDto, Products.class);

                        product.setSellerId(userService.getRandomUser());
                        product.setBuyerId(userService.getRandomUser());

                        product.setCategories(categoryService.getRandomCategories());
                        return product;

                    })
                    .forEach(productRepository::save);
        }
    }
}
