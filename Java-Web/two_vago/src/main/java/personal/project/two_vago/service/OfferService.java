package personal.project.two_vago.service;

import org.springframework.stereotype.Service;
import personal.project.two_vago.models.entities.view.OfferSummaryView;
import personal.project.two_vago.models.service.OfferServiceModel;

import java.util.List;

@Service
public interface OfferService {
    OfferServiceModel addOffer(OfferServiceModel offerServiceModel);

    List<OfferSummaryView> getAllOffers();
}
