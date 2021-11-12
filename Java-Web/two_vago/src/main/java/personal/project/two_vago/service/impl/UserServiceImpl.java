package personal.project.two_vago.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import personal.project.two_vago.models.entities.Role;
import personal.project.two_vago.models.entities.User;
import personal.project.two_vago.models.entities.enums.RoleNameEnum;
import personal.project.two_vago.models.service.UserServiceModel;
import personal.project.two_vago.repository.RoleRepository;
import personal.project.two_vago.repository.UserRepository;
import personal.project.two_vago.security.CurrentUser;
import personal.project.two_vago.service.UserService;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleRepository roleRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        Role adminRole = roleRepository.findByRoleName(RoleNameEnum.ADMIN);
        Role userRole = roleRepository.findByRoleName(RoleNameEnum.USER);

        User user = modelMapper.map(userServiceModel, User.class);

        if(userRepository.count() == 0){
            user.setRole(adminRole);
        }else{
            user.setRole(userRole);
        }
        userRepository.save(user);

        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public void initializeRoles() {
        if(roleRepository.count() !=0){
            return;
        }

        if (userRepository.count() == 0) {
            Role adminRole = new Role();
            adminRole.setRoleName(RoleNameEnum.ADMIN);

            Role userRole = new Role();
            userRole.setRoleName(RoleNameEnum.USER);

            roleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(Long id, String fullName, Role role) {
        currentUser.setId(id);
        currentUser.setFullName(fullName);
        currentUser.setRole(role);
    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id)
                .orElse(null);
    }
}
