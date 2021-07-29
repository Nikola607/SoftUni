package com.example.demo.service;

import com.example.demo.model.dto.UserSeedDto;
import com.example.demo.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();
}
