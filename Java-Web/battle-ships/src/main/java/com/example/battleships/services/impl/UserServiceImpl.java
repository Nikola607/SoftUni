package com.example.battleships.services.impl;

import com.example.battleships.models.entities.User;
import com.example.battleships.models.service.UserServiceModel;
import com.example.battleships.repositories.UserRepository;
import com.example.battleships.security.CurrentUser;
import com.example.battleships.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
    public UserServiceModel registerUser(UserServiceModel userServiceModelModel) {
        User user = modelMapper.map(userServiceModelModel, User.class);

        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findAllByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setUsername(username);
        currentUser.setId(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findAllById(id)
                .orElse(null);
    }
}
