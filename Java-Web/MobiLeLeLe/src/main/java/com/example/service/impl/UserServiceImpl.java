package com.example.service.impl;

import com.example.models.entity.User;
import com.example.models.entity.UserRoles;
import com.example.models.entity.enums.Role;
import com.example.models.service.UserLoginServiceModel;
import com.example.models.service.UserRegistrationServiceModel;
import com.example.repository.UserRepository;
import com.example.repository.UserRolesRepository;
import com.example.service.UserService;
import com.example.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRolesRepository userRoleRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder,
                           UserRepository userRepository,
                           UserRolesRepository userRoleRepository,
                           CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void initializeUsersAndRoles() {
        initializeRoles();
        initializeUsers();
    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {

            UserRoles adminRole = userRoleRepository.findByRole(Role.ADMIN);
            UserRoles userRole = userRoleRepository.findByRole(Role.USER);

            User admin = new User();
            admin
                    .setUsername("admin");
            admin
                    .setPassword(passwordEncoder.encode("test"));
            admin
                    .setFirstName("Admin");
            admin
                    .setLastName("Adminov");
            admin
                    .setActive(true);

            admin.setRole(Set.of(adminRole, userRole));
            userRepository.save(admin);

            User pesho = new User();
            pesho
                    .setUsername("pesho");
            pesho
                    .setPassword(passwordEncoder.encode("test"));
            pesho
                    .setFirstName("Pesho");
            pesho
                    .setLastName("Petrov");
            pesho
                    .setActive(true);

            pesho.setRole(Set.of(userRole));
            userRepository.save(pesho);
        }
    }

    private void initializeRoles() {

        if (userRoleRepository.count() == 0) {
            UserRoles adminRole = new UserRoles();
            adminRole.setRole(Role.ADMIN);

            UserRoles userRole = new UserRoles();
            userRole.setRole(Role.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

    @Override
    public boolean login(UserLoginServiceModel loginServiceModel) {

        Optional<User> userEntityOpt =
                userRepository.findByUsername(loginServiceModel.getUsername());

        if (userEntityOpt.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = passwordEncoder.matches(
                    loginServiceModel.getRawPassword(),
                    userEntityOpt.get().getPassword());

            if (success) {
                User loggedInUser = userEntityOpt.get();
                login(loggedInUser);

                loggedInUser.getRole().
                        forEach(r -> currentUser.addRole(r.getRole()));
            }

            return success;
        }
    }

    @Override
    public void logout() {
        currentUser.clean();
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel) {

        UserRoles userRole = userRoleRepository.findByRole(Role.USER);

        User newUser = new User();

        newUser.
                setUsername(userRegistrationServiceModel.getUsername());
                newUser
                        .setFirstName(userRegistrationServiceModel.getFirstName());
                newUser
                        .setLastName(userRegistrationServiceModel.getLastName());
                newUser
                        .setActive(true);
                newUser
                        .setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()));
                newUser
                        .setRole(Set.of(userRole));

        newUser = userRepository.save(newUser);

        login(newUser);
    }

    public boolean isUserNameFree(String username) {
        return userRepository.findByUsernameIgnoreCase(username).
                isEmpty();
    }

    private void login(User user) {
        currentUser.
                setLoggedIn(true).
                setUserName(user.getUsername()).
                setFirstName(user.getFirstName()).
                setLastName(user.getLastName());
    }
}
