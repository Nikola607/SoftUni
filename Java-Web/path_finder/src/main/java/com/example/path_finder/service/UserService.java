package com.example.path_finder.service;

import com.example.path_finder.models.enities.service.UserServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserServiceModel registerUser(UserServiceModel userRegisterServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
}
