package war.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import war.repository.FarmerRepository;

@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories(basePackageClasses = FarmerRepository.class)
public class MainController {
    public static void main(String[] args) {
        SpringApplication.run(MainController.class, args);
    }
}
