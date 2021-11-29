package personal.project.two_vago.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import personal.project.two_vago.models.entities.Offer;
import personal.project.two_vago.models.entities.enums.CategoryNameEnum;
import personal.project.two_vago.models.entities.enums.CityNameEnum;
import personal.project.two_vago.models.entities.view.OfferDetailsView;
import personal.project.two_vago.models.entities.view.OfferSummaryView;
import personal.project.two_vago.models.service.OfferServiceModel;
import personal.project.two_vago.repository.CategoryRepository;
import personal.project.two_vago.repository.CityRepository;
import personal.project.two_vago.repository.OfferRepository;
import personal.project.two_vago.repository.UserRepository;
import personal.project.two_vago.service.CategoryService;
import personal.project.two_vago.service.CityService;
import personal.project.two_vago.service.OfferService;
import personal.project.two_vago.service.UserService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OfferServiceImpl implements OfferService {
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final CityService cityService;
    private final UserService userService;
    private final OfferRepository offerRepository;
    private final CityRepository cityRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public OfferServiceImpl(ModelMapper modelMapper, CategoryService categoryService, CityService cityService, UserService userService, OfferRepository offerRepository, CityRepository cityRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.cityService = cityService;
        this.userService = userService;
        this.offerRepository = offerRepository;
        this.cityRepository = cityRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
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

    @Override
    public List<OfferSummaryView> getAllOffers() {
        return offerRepository.
                findAll().
                stream().
                map(this::map).
                collect(Collectors.toList());
    }

    @Override
    public OfferDetailsView findById(Long id, String currentUser) {
        OfferDetailsView offerDetailsView = this.offerRepository.
                findById(id).
                map(o -> mapDetailsView(currentUser, o))
                .get();
        return offerDetailsView;
    }

    @Override
    public void initializeOffers() {
        if (offerRepository.count() == 0){
            Offer offer1 = new Offer();
            offer1.setOfferName("Grand Hotel Bansko");
            offer1.setDescription("Grand Hotel Bansko offers a panoramic view to its guests of the whole town and the\n" +
                    "                                beautiful nature\n" +
                    "                                that surrounds it.");
            offer1.setPicture("https://cf.bstatic.com/xdata/images/hotel/max1280x900/40778632.jpg?k=a385de720bd1fce29476c72bba07d446a483a2142c59d5b9280984059e435d5d&o=&hp=1");
            offer1.setPrice(BigDecimal.valueOf(225));
            offer1.setCity(cityRepository.findByName(CityNameEnum.Bansko).orElse(null));
            offer1.setCategory(categoryRepository.findByCategoryName(CategoryNameEnum.HOTEL).orElse(null));
            offer1.setUser(userRepository.findByUsername("admin").orElse(null));

            Offer offer2 = new Offer();
            offer2.setOfferName("Villa EM");
            offer2.setDescription("Villa EM features a restaurant, seasonal outdoor swimming pool, a shared lounge and garden in Lozenets.");
            offer2.setPicture("https://rezervaciq.com/img/objects/1557907530-vila-em-9885.jpg");
            offer2.setPrice(BigDecimal.valueOf(95));
            offer2.setCity(cityRepository.findByName(CityNameEnum.Velingrad).orElse(null));
            offer2.setCategory(categoryRepository.findByCategoryName(CategoryNameEnum.VILLA).orElse(null));
            offer2.setUser(userRepository.findByUsername("admin").orElse(null));

            Offer offer3 = new Offer();
            offer3.setOfferName("Hotel Luxor");
            offer3.setDescription("Hotel Luxor offers a pool and free deckchairs, a large garden with a children’s playground and free Wi-Fi connection in the entire building.");
            offer3.setPicture("https://www.4suiteshq.com/wp-content/uploads/2020/03/173429314-500x334.jpg");
            offer3.setPrice(BigDecimal.valueOf(160));
            offer3.setCity(cityRepository.findByName(CityNameEnum.Primorsko).orElse(null));
            offer3.setCategory(categoryRepository.findByCategoryName(CategoryNameEnum.HOTEL).orElse(null));
            offer3.setUser(userRepository.findByUsername("admin").orElse(null));

            offerRepository.saveAll(List.of(offer1, offer2, offer3));
        }
    }

    private OfferDetailsView mapDetailsView(String currentUser, Offer offer) {
        OfferDetailsView offerDetailsView = this.modelMapper.map(offer, OfferDetailsView.class);
        //TODO
        //offerDetailsView.setCanDelete(isOwner(currentUser, offer.getId()));
        offerDetailsView.setCategory(offer.getCategory().getCategoryName());
        offerDetailsView.setCity(offer.getCity().getName());
//        offerDetailsView.setSellerName(
//                offer.getUser().getFullName()
//        );
        return offerDetailsView;
    }

    private OfferSummaryView map(Offer offerEntity) {
        OfferSummaryView summaryView = this.modelMapper
                .map(offerEntity, OfferSummaryView.class);

        summaryView.setCity(offerEntity.getCity().getName());
        summaryView.setCategory(offerEntity.getCategory().getCategoryName());

        return summaryView;
    }
}
