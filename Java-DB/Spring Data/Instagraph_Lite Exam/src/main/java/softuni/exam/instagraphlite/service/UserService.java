package softuni.exam.instagraphlite.service;

import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.models.entity.Users;

import java.io.IOException;

@Service
public interface UserService {
    boolean areImported();
    String readFromFileContent() throws IOException;
    String importUsers() throws IOException;

    boolean isEntityExists(String username);

    String exportUsersWithTheirPosts();

    Users findByUsername(String username);

}
