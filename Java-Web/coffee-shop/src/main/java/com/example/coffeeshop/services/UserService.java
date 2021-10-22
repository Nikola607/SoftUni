package com.example.coffeeshop.services;

import com.example.coffeeshop.model.entities.User;
import com.example.coffeeshop.model.service.UserRegisterServiceModel;
import com.example.coffeeshop.model.view.UserViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserRegisterServiceModel registerUser(UserRegisterServiceModel userRegisterServiceModel);

    UserRegisterServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUsersByCountOfOrders();
}
