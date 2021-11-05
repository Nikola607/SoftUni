package com.example.path_finder.service.impl;

import com.example.path_finder.models.enities.Role;
import com.example.path_finder.models.enities.User;
import com.example.path_finder.models.enities.enums.LevelEnum;
import com.example.path_finder.models.enities.enums.RoleNameEnum;
import com.example.path_finder.models.enities.service.UserServiceModel;
import com.example.path_finder.models.view.UserProfileView;
import com.example.path_finder.repository.RoleRepository;
import com.example.path_finder.repository.UserRepository;
import com.example.path_finder.security.CurrentUser;
import com.example.path_finder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final RoleRepository roleRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser, RoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        Role userRole = roleRepository.findByName(RoleNameEnum.USER);
        Role adminRole = roleRepository.findByName(RoleNameEnum.ADMIN);
        userServiceModel.getRoles().add(userRole);
        if (userRepository.count() == 0) {
            userServiceModel.getRoles().add(adminRole);
        }
        User newUser = modelMapper.map(userServiceModel, User.class);

        newUser.setLevel(LevelEnum.BEGINNER);
        userRepository.save(newUser);

        return modelMapper.map(userRepository.save(newUser), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findAllByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username, String fullName, Set<Role> roles) {
        currentUser.setLoggedIn(true);
        currentUser.setId(id);
        currentUser.setUsername(username);
        currentUser.setFullName(fullName);
        currentUser.setRoles(roles);
    }

    @Override
    public UserProfileView findByUsername(String username) {

        return modelMapper.map(userRepository.findAllByUsername(username), UserProfileView.class);
    }
}
