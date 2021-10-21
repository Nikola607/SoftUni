package com.example.coffeeshop.services;

import com.example.coffeeshop.model.service.OrderServiceModel;
import com.example.coffeeshop.model.view.OrderViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    OrderServiceModel addOrder(OrderServiceModel serviceModel);

    List<OrderViewModel> findAllOrdersByPrice();
}
