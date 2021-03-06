package personal.project.two_vago.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import personal.project.two_vago.models.entities.*;
import personal.project.two_vago.models.entities.enums.RankNameEnum;
import personal.project.two_vago.models.entities.enums.RoleNameEnum;
import personal.project.two_vago.models.entities.view.UserViewModel;
import personal.project.two_vago.models.service.UserServiceModel;
import personal.project.two_vago.repository.OfferRepository;
import personal.project.two_vago.repository.RankRepository;
import personal.project.two_vago.repository.RoleRepository;
import personal.project.two_vago.repository.UserRepository;
import personal.project.two_vago.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final TwoVagoUserServiceImpl twoVagoUserService;
    private final OfferRepository offerRepository;
    private final RankRepository rankRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleRepository roleRepository, PasswordEncoder passwordEncoder, TwoVagoUserServiceImpl twoVagoUserService, OfferRepository offerRepository, RankRepository rankRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.twoVagoUserService = twoVagoUserService;
        this.offerRepository = offerRepository;
        this.rankRepository = rankRepository;
    }

    @Override
    public boolean registerAndLoginUser(UserServiceModel userRegistrationServiceModel) {
        Role userRole = roleRepository.findByRoleName(RoleNameEnum.USER);
        Rank userRank = rankRepository.findByRankName(RankNameEnum.BEGINNER);

        User newUser = new User();

        newUser.
                setUsername(userRegistrationServiceModel.getUsername());
        newUser
                .setFullName(userRegistrationServiceModel.getFullName());
        newUser
                .setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()));
        newUser
                .setRole(userRole);
        newUser
                .setEmail(userRegistrationServiceModel.getEmail());
        newUser
                .setAge(userRegistrationServiceModel.getAge());

        newUser
                .setProfilePic(getRandomProfilePic());
        newUser
                .setNumber(userRegistrationServiceModel.getNumber());

        newUser.setLoginDays(0);
        newUser.setRank(userRank);

        try {
            newUser = userRepository.save(newUser);
        } catch (Exception e) {
            return false;
        }

        // this is the Spring representation of a user
        UserDetails principal = twoVagoUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.
                getContext().
                setAuthentication(authentication);
        return true;
    }

    private String getRandomProfilePic() {
        int random = new Random().nextInt(6);
        return "/images/profilePictures/" + random + ".png";
    }

    @Override
    public void initializeRanks() {
        if (rankRepository.count() != 0) {
            return;
        }

        Arrays.stream(RankNameEnum.values())
                .forEach(rankNameEnum -> {
                            Rank rank = new Rank();
                            rank.setRankName(rankNameEnum);
                            rankRepository.save(rank);
                        }
                );
    }

    @Override
    public boolean isUserNameFree(String userName) {
        return userRepository.findByUsernameIgnoreCase(userName.toLowerCase()).isEmpty();
    }

    @Override
    public void initializeRoles() {
        if (roleRepository.count() != 0) {
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

    public void initializeUsers() {
        if (userRepository.count() == 0) {

            Role adminRole = roleRepository.findByRoleName(RoleNameEnum.ADMIN);
            Rank adminRank = rankRepository.findByRankName(RankNameEnum.VETERAN);

            User admin = new User();
            admin
                    .setUsername("admin");
            admin
                    .setPassword(passwordEncoder.encode("test"));
            admin
                    .setFullName("Jesus");
            admin
                    .setAge(999);
            admin
                    .setEmail("admin@admin.com");
            admin
                    .setRole(adminRole);
            admin
                    .setProfilePic(getRandomProfilePic());
            admin
                    .setNumber("088420420");

            admin.setRole(adminRole);
            admin.setLoginDays(30);
            admin.setRank(adminRank);

            userRepository.save(admin);
        }
    }

    @Override
    public UserViewModel getViewModelByUsername(String name) {
        return this.userRepository
                .findByUsername(name)
                .map(u -> this.modelMapper.map(u, UserViewModel.class))
                .orElseThrow();
    }

    @Override
    public UserViewModel changeProfilePic(String name) {
        User user = userRepository.findByUsername(name).orElse(null);
        user.setProfilePic(getRandomProfilePic());

        userRepository.save(user);

        return modelMapper.map(user, UserViewModel.class);
    }

    @Override
    public void setLoggedIn() {
        List<User> users = userRepository.findAll();
        users.forEach(u-> u.setWasLoggedInToday(false));

        userRepository.saveAll(users);
    }

    @Override
    public void loginPointSystem(String name) {
        User user = userRepository.findByUsername(name).orElse(null);

        if (!user.isWasLoggedInToday()) {
            user.setLoginDays(user.getLoginDays() + 1);
        }
        user.setWasLoggedInToday(true);
        userRepository.save(user);
    }

//    @Override
//    public List<UserViewModel> getOffersByUser(String name) {
//        User user = userRepository.findByUsername(name).orElse(null);
//
//        return offerRepository.findAllByUser(user).stream()
//                .map(this::map)
//                .collect(Collectors.toList());
//    }
//
//    private UserViewModel map(Offer offerEntity) {
//
//        return this.modelMapper
//                 .map(offerEntity, UserViewModel.class);
//    }


    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id)
                .orElse(null);
    }
}
