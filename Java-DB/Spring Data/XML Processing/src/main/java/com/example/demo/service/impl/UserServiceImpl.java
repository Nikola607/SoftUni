package com.example.demo.service.impl;

import com.example.demo.model.dto.UserSeedDto;
import com.example.demo.model.dto.UserViewRootDto;
import com.example.demo.model.dto.UserWithSoldProductDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers(List<UserSeedDto> users) {
        if (userRepository.count() == 0) {
            users.stream()
                    .filter(validationUtil::isValid)
                    .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                    .forEach(userRepository::save);
        }
    }

    @Override
    public User getRandomUser() {
        long getRandomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);

        return userRepository
                .findById(getRandomId)
                .orElse(null);
    }

    @Override
    public UserViewRootDto findUsersWithMoreThatOneProduct() {
        UserViewRootDto userViewRootDto = new UserViewRootDto();
        userViewRootDto.setProducts(userRepository
                .findAllUsersWithMoreThatOneSoldProduct()
        .stream()
        .map(user -> modelMapper.map(user, UserWithSoldProductDto.class))
        .collect(Collectors.toList()));

        return userViewRootDto;
    }
}
