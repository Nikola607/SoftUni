package com.example.web;

import com.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;

public class UserLogoutController {
    private final UserService userService;

    public UserLogoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }
}
