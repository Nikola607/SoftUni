package personal.project.two_vago.web.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import personal.project.two_vago.service.UserService;

import java.security.Principal;

@Component
public class CronScheduler {
    private final UserService userService;

    public CronScheduler(UserService userService) {
        this.userService = userService;
    }

    @Scheduled(cron = "0 0 * * *")
    public void loggedInCron(Principal principal){
        userService.setLoggedIn(principal.getName());
    }
}
