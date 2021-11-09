package personal.project.two_vago.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import personal.project.two_vago.service.UserService;

@Component
public class DBInit implements CommandLineRunner {
    private final UserService userService;

    public DBInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.initializeRoles();
    }
}
