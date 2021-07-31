package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import softuni.exam.instagraphlite.models.models.entity.Users;
import softuni.exam.instagraphlite.models.models.jsondto.UsersSeedDto;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Component
public class UserServiceImpl implements UserService {
    public static final String USER_FILE_PATH = "src/main/resources/files/users.json";

    private final PictureService pictureService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(PictureService pictureService, UserRepository userRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.pictureService = pictureService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();
        UsersSeedDto[] usersSeedDtos = gson.fromJson(readFromFileContent(), UsersSeedDto[].class);

        Arrays.stream(usersSeedDtos)
                .filter(usersSeedDto -> {
                    boolean isValid = validationUtil.isValid(usersSeedDto)
                            && !isEntityExists(usersSeedDto.getUsername())
                            && pictureService.isEntityExists(usersSeedDto.getProfilePicture());

                    sb.append(isValid ? String.format("Successfully imported User: %s",
                            usersSeedDto.getUsername()) : String.format("Invalid User"));

                    return isValid;
                })
                .map(usersSeedDto -> {
                    Users users = modelMapper.map(usersSeedDto, Users.class);

                    users.setProfilePicture(pictureService
                            .findByPath(usersSeedDto.getProfilePicture()));

                    return users;
                })
                .forEach(userRepository::save);

        return sb.toString();
    }

    @Override
    public boolean isEntityExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();

        userRepository.findAllByPostsAndOrderByPostsCountDescThenByUserId()
                .stream()
                .forEach(user -> {
                    sb.append(String.format("User: %s\n" +
                            "Post count: %d\n", user.getUsername(), user.getPosts().size()));

                    user.getPosts()
                            .stream()
                            .forEach(posts -> {
                                sb.append(String.format("==Post Details:\n" +
                                        "----Caption: %s\n" +
                                        "----Picture Size: %.2f\n",
                                        posts.getCaption(), posts.getPicture().getSize()));
                            });
                });

        return sb.toString();
    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElse(null);

    }
}
