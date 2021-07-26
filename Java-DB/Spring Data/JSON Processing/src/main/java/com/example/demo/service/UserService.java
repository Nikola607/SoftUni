package com.example.demo.service;

import com.example.demo.model.entity.User;

import java.io.IOException;

public interface UserService {
    void seedUsers() throws IOException;

    User findRandomUser();
}
