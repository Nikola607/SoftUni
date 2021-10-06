package com.example.service;

import com.example.models.view.OfferSummaryView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfferService {
    void initializeOffers();

    List<OfferSummaryView> getAllOffers();
}
