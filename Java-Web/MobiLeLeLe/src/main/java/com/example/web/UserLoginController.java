package com.example.web;

import com.example.models.binding.UserLoginBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping()
    public String login(UserLoginBindingModel userLoginBindingModel){

        return "redirect:/index";
    }
}
