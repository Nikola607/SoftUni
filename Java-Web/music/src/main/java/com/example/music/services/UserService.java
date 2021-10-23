package com.example.music.services;

import com.example.music.model.entities.User;
import com.example.music.model.service.UserServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);
}
