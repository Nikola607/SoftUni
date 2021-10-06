package com.example.service.impl;

import com.example.models.entity.Brand;
import com.example.repository.BrandRepository;
import com.example.service.BrandService;
import org.springframework.stereotype.Component;

@Component
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void initializeBrand() {
        if (brandRepository.count() == 0) {
            Brand ford = new Brand();
            ford.setName("Ford");

            brandRepository.save(ford);
        }
    }
}
