package personal.project.two_vago.service;

import org.springframework.stereotype.Service;
import personal.project.two_vago.models.entities.Role;
import personal.project.two_vago.models.entities.User;
import personal.project.two_vago.models.service.UserServiceModel;

@Service
public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    void initializeRoles();

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void login(Long id, String fullName, Role role);

    User findById(Long id);
}
