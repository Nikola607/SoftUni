package com.example.service.impl;

import com.example.models.entity.Brand;
import com.example.models.entity.Model;
import com.example.models.entity.enums.Category;
import com.example.repository.BrandRepository;
import com.example.repository.ModelRepository;
import com.example.service.ModelService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void initializeModels() {

        Brand ford = brandRepository.findByName("Ford")
                .orElseThrow(IllegalArgumentException::new);

        Model fiesta = new Model();
        fiesta
                .setName("Fiesta");
        fiesta
                .setCategory(Category.CAR);
        fiesta
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/1920px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg");
        fiesta
                .setStartYear(1976);
        fiesta
                .setBrand(ford);
        Model escort = new Model();
        escort
                .setName("Escort");
        escort
                .setCategory(Category.CAR);
        escort
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Ford_Escort_RS2000_MkI.jpg/420px-Ford_Escort_RS2000_MkI.jpg");
        escort
                .setStartYear(1967);
        escort
                .setEndYear(2004);
        escort
                .setBrand(ford);

        modelRepository.saveAll(List.of(fiesta, escort));
    }

    @Override
    public Model findById(Long id) {
        return modelRepository.findById(id).orElse(null);
    }

}
