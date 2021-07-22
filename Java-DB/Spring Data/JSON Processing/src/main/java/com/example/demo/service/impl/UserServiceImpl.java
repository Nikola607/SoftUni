package com.example.demo.service.impl;

import com.example.demo.constraint.GlobalConstraint;
import com.example.demo.model.dto.UserSeedDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static com.example.demo.constraint.GlobalConstraint.RESOURCES_FILES_PATH;

@Service
public class UserServiceImpl implements UserService {
    public static final String USERS_FILE_NAME = "users.json";
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, UserRepository userRepository) {
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void seedUsers() throws IOException {
        if(userRepository.count() > 0){
            return;
        }

        String fileContent = Files
                .readString(Path.of(RESOURCES_FILES_PATH + USERS_FILE_NAME));

        UserSeedDto[] userSeedDtos = gson
                .fromJson(fileContent, UserSeedDto[].class);

        Arrays.stream(userSeedDtos)
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);
    }
}
