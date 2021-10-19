package com.example.coffeeshop.init;

import com.example.coffeeshop.services.CategoryService;
import com.example.coffeeshop.services.OrderService;
import com.example.coffeeshop.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private final CategoryService categoryService;
    private final UserService userService;
    private final OrderService orderService;

    public DBInit(CategoryService categoryService, UserService userService, OrderService orderService) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategories();

    }
}
