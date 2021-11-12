package personal.project.two_vago.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import personal.project.two_vago.service.CategoryService;
import personal.project.two_vago.service.CityService;
import personal.project.two_vago.service.UserService;

@Component
public class DBInit implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;
    private final CityService cityService;

    public DBInit(UserService userService, CategoryService categoryService, CityService cityService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.cityService = cityService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.initializeRoles();
        categoryService.initializeRoles();
        cityService.initializeRoles();
    }
}
