package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.xmldto.OfferSeedRootDto;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class OfferServiceImpl implements OfferService {
    public static final String OFFER_OUTPUT_FILE = "src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;
    private final CarService carService;
    private final SellerService sellerService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public OfferServiceImpl(OfferRepository offerRepository, CarService carService, SellerService sellerService, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.offerRepository = offerRepository;
        this.carService = carService;
        this.sellerService = sellerService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFER_OUTPUT_FILE));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(OFFER_OUTPUT_FILE, OfferSeedRootDto.class)
                .getOffers()
                .stream()
                .filter(offerSeedDto -> {
                    boolean isValid = validationUtil.isValid(offerSeedDto);

                    sb.append(isValid ? String.format("Successfully import offer %s - true", offerSeedDto.getAddedOn()) :
                            String.format("Invalid offer"));
                    sb.append(System.lineSeparator());

                    return isValid;
                })
                .map(offerSeedDto -> {
                    Offer offer = modelMapper.map(offerSeedDto, Offer.class);

                    offer.setCar(carService.findById(offerSeedDto.getCar().getId()));

                    offer.setSeller(sellerService.findById(offerSeedDto.getSeller().getId()));

                    return offer;
                })
        .forEach(offerRepository::save);

        return sb.toString();
    }
}
