package com.example.path_finder.service;

import com.example.path_finder.models.enities.Role;
import com.example.path_finder.models.enities.service.UserServiceModel;
import com.example.path_finder.models.view.UserProfileView;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {
    UserServiceModel registerUser(UserServiceModel userRegisterServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username, String fullName, Set<Role> roles);

    UserProfileView findByUsername(String username);
}
