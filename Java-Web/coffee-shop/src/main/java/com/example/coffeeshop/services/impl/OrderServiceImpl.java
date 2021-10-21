package com.example.coffeeshop.services.impl;

import com.example.coffeeshop.model.entities.Order;
import com.example.coffeeshop.model.service.OrderServiceModel;
import com.example.coffeeshop.model.view.OrderViewModel;
import com.example.coffeeshop.repositories.OrderRepository;
import com.example.coffeeshop.security.CurrentUser;
import com.example.coffeeshop.services.CategoryService;
import com.example.coffeeshop.services.OrderService;
import com.example.coffeeshop.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public OrderServiceModel addOrder(OrderServiceModel serviceModel) {
        Order order =modelMapper.map(serviceModel, Order.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryName(serviceModel.getCategory()));

        orderRepository.save(order);

        return modelMapper.map(order, OrderServiceModel.class);
    }

    @Override
    public List<OrderViewModel> findAllOrdersByPrice() {

        return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }
}
