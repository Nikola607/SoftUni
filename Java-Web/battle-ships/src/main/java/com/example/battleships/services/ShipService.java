package com.example.battleships.services;

import com.example.battleships.models.service.ShipServiceModel;
import com.example.battleships.models.view.ShipViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipService {
    ShipServiceModel addShip(ShipServiceModel shipServiceModel);

    List<ShipViewModel> findAllShips();

    void fire(Long id);

    List<ShipViewModel> findAllLoggedInShips(Long id);
}
