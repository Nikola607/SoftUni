package personal.project.two_vago.service;

import org.springframework.stereotype.Service;
import personal.project.two_vago.models.service.OfferServiceModel;

@Service
public interface OfferService {
    OfferServiceModel addOffer(OfferServiceModel offerServiceModel);
}
