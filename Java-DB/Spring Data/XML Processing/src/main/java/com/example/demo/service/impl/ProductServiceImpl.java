package com.example.demo.service.impl;

import com.example.demo.model.dto.ProductSeedDto;
import com.example.demo.model.dto.ProductViewRootDto;
import com.example.demo.model.dto.ProductsWithSellerDto;
import com.example.demo.model.entity.Products;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import com.example.demo.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
        if (productRepository.count() == 0) {
            products.stream()
                    .filter(validationUtil::isValid)
                    .map(productSeedDto -> {
                        Products product = modelMapper.map(productSeedDto, Products.class);

                        product.setSellerId(userService.getRandomUser());
                        if(product.getPrice().compareTo(BigDecimal.valueOf(700)) > 0) {
                            product.setBuyerId(userService.getRandomUser());
                        }

                        product.setCategories(categoryService.getRandomCategories());
                        return product;

                    })
                    .forEach(productRepository::save);
        }
    }

    @Override
    public ProductViewRootDto findProductsWithoutBuyer() {
        ProductViewRootDto rootDto = new ProductViewRootDto();

        rootDto
                .setProducts(productRepository
                        .findAllByPriceBetweenAndBuyerIdIsNull(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L))
                        .stream()
                        .map(products -> {
                            ProductsWithSellerDto product = modelMapper.map(products, ProductsWithSellerDto.class);

                            product.setSeller(String.format("%s %s",
                                    products.getSellerId().getFirstName(),
                                    products.getSellerId().getLastName()));

                            return product;
                        })
                        .collect(Collectors.toList()));

        return rootDto;
    }
}
