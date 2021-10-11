package com.example.service.impl;

import com.example.models.entity.Offer;
import com.example.models.entity.enums.Engine;
import com.example.models.entity.enums.Transmission;
import com.example.models.view.OfferDetailsView;
import com.example.models.view.OfferSummaryView;
import com.example.repository.ModelRepository;
import com.example.repository.OfferRepository;
import com.example.repository.UserRepository;
import com.example.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ModelRepository modelRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void initializeOffers() {

        if (offerRepository.count() == 0) {
            Offer offer1 = new Offer();
            offer1
                    .setModels(modelRepository.findById(1L).orElse(null));
            offer1
                    .setEngine(Engine.GASOLINE);
            offer1
                    .setTransmission(Transmission.MANUAL);
            offer1
                    .setMileage(22500);
            offer1
                    .setPrice(BigDecimal.valueOf(14300));
            offer1
                    .setYear(2019);
            offer1
                    .setDescription("Used, but well services and in good condition.");
            offer1
                    .setSeller(userRepository.findByUsername("pesho")
                            .orElse(null)); // or currentUser.getUserName()
            offer1
                    .setImageUrl(
                            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcXp1KBpDKgYs6VqndkBpX8twjPOZbHV86yg&usqp=CAU");

            Offer offer2 = new Offer();
            offer2
                    .setModels(modelRepository.findById(1L).orElse(null));
            offer2
                    .setEngine(Engine.DIESEL);
            offer2
                    .setTransmission(Transmission.AUTOMATIC);
            offer2
                    .setMileage(209000);
            offer2
                    .setPrice(BigDecimal.valueOf(5500));
            offer2
                    .setYear(2000);
            offer2
                    .setDescription("After full maintenance, insurance, new tires...");
            offer2
                    .setSeller(userRepository.findByUsername("admin")
                            .orElse(null)); // or currentUser.getUserName()
            offer2
                    .setImageUrl(
                            "https://www.picclickimg.com/d/l400/pict/283362908243_/FORD-ESCORT-MK5-16L-DOHC-16v-ZETEC.jpg");

            offerRepository.saveAll(List.of(offer1, offer2));
        }
    }

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepository.
                findAll().
                stream().
                map(this::map).
                collect(Collectors.toList());
    }

    @Override
    public OfferDetailsView findById(Long id) {
        OfferDetailsView offerDetailsView = this.offerRepository.findById(id).map(this::mapDetailsView).get();
        return offerDetailsView;
    }

    private OfferSummaryView map(Offer offerEntity) {
        OfferSummaryView summaryView = this.modelMapper
                .map(offerEntity, OfferSummaryView.class);

        summaryView.setModel(offerEntity.getModels().getName());

        return summaryView;
    }

    private OfferDetailsView mapDetailsView(Offer offer) {
        OfferDetailsView offerDetailsView = this.modelMapper.map(offer, OfferDetailsView.class);
        offerDetailsView.setModel(offer.getModels().getName());
        offerDetailsView.setBrand(offer.getModels().getBrand().getName());
        offerDetailsView.setSellerFullName(offer.getSeller().getFirstName() + " " + offer.getSeller().getLastName());
        return offerDetailsView;
    }
}
