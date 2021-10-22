package com.example.music.services;

import com.example.music.model.service.UserServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);
}
