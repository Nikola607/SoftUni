package com.example.battleships.services;

import com.example.battleships.models.binding.UserRegisterBindingModel;
import com.example.battleships.models.entities.User;
import com.example.battleships.models.service.UserServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);
}
