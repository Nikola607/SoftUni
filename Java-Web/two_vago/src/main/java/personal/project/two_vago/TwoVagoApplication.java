package personal.project.two_vago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TwoVagoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwoVagoApplication.class, args);
    }

}
