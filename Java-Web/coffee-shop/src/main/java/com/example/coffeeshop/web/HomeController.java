package com.example.coffeeshop.web;

import com.example.coffeeshop.model.view.OrderViewModel;
import com.example.coffeeshop.security.CurrentUser;
import com.example.coffeeshop.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final OrderService orderService;

    public HomeController(CurrentUser currentUser, OrderService orderService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
    }

    @GetMapping()
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        List<OrderViewModel> orderViewModels = orderService.findAllOrdersByPrice();

        model.addAttribute("orders", orderService.findAllOrdersByPrice());
        model.addAttribute("totalTime", orderViewModels
                .stream()
                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
        .reduce(Integer::sum)
        .orElse(0));

        return "home";
    }
}
