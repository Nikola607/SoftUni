package personal.project.two_vago.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import personal.project.two_vago.models.entities.Offer;
import personal.project.two_vago.models.service.OfferServiceModel;
import personal.project.two_vago.repository.OfferRepository;
import personal.project.two_vago.service.CategoryService;
import personal.project.two_vago.service.CityService;
import personal.project.two_vago.service.OfferService;
import personal.project.two_vago.service.UserService;

@Component
public class OfferServiceImpl implements OfferService {
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final CityService cityService;
    private final UserService userService;
    private final OfferRepository offerRepository;

    public OfferServiceImpl(ModelMapper modelMapper, CategoryService categoryService, CityService cityService, UserService userService, OfferRepository offerRepository) {
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.cityService = cityService;
        this.userService = userService;
        this.offerRepository = offerRepository;
    }

    @Override
    public OfferServiceModel addOffer(OfferServiceModel offerServiceModel) {
        Offer offer = modelMapper.map(offerServiceModel, Offer.class);

        offer.setCategory(categoryService.findByCategoryName(offerServiceModel.getCategory()));
        offer.setCity(cityService.findByCityName(offerServiceModel.getCity()));
//        TODO
//        offer.setUser(userService.findById(currentUser.getId()));

        offerRepository.save(offer);

        return modelMapper.map(offer, OfferServiceModel.class);
    }
}
