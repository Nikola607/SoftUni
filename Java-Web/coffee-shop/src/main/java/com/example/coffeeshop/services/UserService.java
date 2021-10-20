package com.example.coffeeshop.services;

import com.example.coffeeshop.model.service.UserRegisterServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserRegisterServiceModel registerUser(UserRegisterServiceModel userRegisterServiceModel);

    UserRegisterServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
}
