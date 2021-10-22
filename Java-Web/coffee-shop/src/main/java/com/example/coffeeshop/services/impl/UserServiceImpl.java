package com.example.coffeeshop.services.impl;

import com.example.coffeeshop.model.entities.User;
import com.example.coffeeshop.model.service.UserRegisterServiceModel;
import com.example.coffeeshop.model.view.UserViewModel;
import com.example.coffeeshop.repositories.UserRepository;
import com.example.coffeeshop.security.CurrentUser;
import com.example.coffeeshop.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserRegisterServiceModel registerUser(UserRegisterServiceModel userRegisterServiceModel) {
        User user = modelMapper.map(userRegisterServiceModel, User.class);

        return modelMapper.map(userRepository.save(user), UserRegisterServiceModel.class);
    }

    @Override
    public UserRegisterServiceModel findByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserRegisterServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUsersByCountOfOrders() {
        return userRepository.findAllOrderedByOrdersDescending()
                .stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(user.getUsername());
                    userViewModel.setOrders(user.getOrders().size());

                    return userViewModel;
                }).collect(Collectors.toList());
    }
}
