package com.example.battleships.services.impl;

import com.example.battleships.models.entities.Ship;
import com.example.battleships.models.service.ShipServiceModel;
import com.example.battleships.models.view.ShipViewModel;
import com.example.battleships.repositories.ShipRepository;
import com.example.battleships.security.CurrentUser;
import com.example.battleships.services.CategoryService;
import com.example.battleships.services.ShipService;
import com.example.battleships.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public ShipServiceModel addShip(ShipServiceModel shipServiceModel) {
        Ship ship = modelMapper.map(shipServiceModel, Ship.class);
        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findByCategoryName(shipServiceModel.getCategory()));

        shipRepository.save(ship);

        return modelMapper.map(ship, ShipServiceModel.class);
    }

    @Override
    public List<ShipViewModel> findAllShips() {
       return shipRepository.findAll()
                .stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void fire(Long id) {

    }

    @Override
    public List<ShipViewModel> findAllLoggedInShips(Long id) {
        return shipRepository.findAllById(id)
                .stream()
                .map(ship -> modelMapper.map(ship, ShipViewModel.class))
                .collect(Collectors.toList());
    }
}
