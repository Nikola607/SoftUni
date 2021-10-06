package com.example.service;

import com.example.models.service.UserLoginServiceModel;
import com.example.models.service.UserRegistrationServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void initializeUsersAndRoles();

    boolean login(UserLoginServiceModel loginServiceModel);

    void logout();

    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

    boolean isUserNameFree(String username);
}
