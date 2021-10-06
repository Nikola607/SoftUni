package com.example.init;

import com.example.service.BrandService;
import com.example.service.ModelService;
import com.example.service.OfferService;
import com.example.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;
    private final OfferService offerService;

    public DBInit(BrandService brandService, ModelService modelService, UserService userService,
                  OfferService offerService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.initializeBrand();
        modelService.initializeModels();
        userService.initializeUsersAndRoles();
        offerService.initializeOffers();
    }
}
