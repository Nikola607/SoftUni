package com.example.demo.service;

import com.example.demo.model.dto.ProductSeedDto;
import com.example.demo.model.dto.ProductViewRootDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void seedProducts(List<ProductSeedDto> products);


    ProductViewRootDto findProductsWithoutBuyer();

}
