package personal.project.two_vago.service;

import org.springframework.stereotype.Service;
import personal.project.two_vago.models.service.UserServiceModel;

@Service
public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    void initializeRoles();
}
