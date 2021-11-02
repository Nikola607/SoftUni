package com.example.path_finder.service.impl;

import com.example.path_finder.models.enities.Role;
import com.example.path_finder.models.enities.User;
import com.example.path_finder.models.enities.enums.LevelEnum;
import com.example.path_finder.models.enities.enums.RoleNameEnum;
import com.example.path_finder.models.enities.service.UserServiceModel;
import com.example.path_finder.repository.UserRepository;
import com.example.path_finder.security.CurrentUser;
import com.example.path_finder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userRegisterServiceModel) {
        User user = modelMapper.map(userRegisterServiceModel, User.class);
        user.setLevel(LevelEnum.BEGINNER);

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
}
