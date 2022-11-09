package com.example.demo.user.domain;

import com.example.demo.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

public class UserConfig {
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER", new ArrayList<>()));
            userService.saveRole(new Role(null, "ROLE_ADMIN",new ArrayList<>()));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN",new ArrayList<>()));
            userService.saveRole(new Role(null, "ROLE_MANAGER",new ArrayList<>()));

            userService.saveUser(new User(null, "Ginni", "Ginni1220", "gins@1220", new ArrayList<>()));
            userService.saveUser(new User(null, "niks", "niks1220", "niks@1220", new ArrayList<>()));
            userService.saveUser(new User(null, "rish", "rish1220", "rish@1220", new ArrayList<>()));
            userService.saveUser(new User(null, "bins", "bins1220", "bins@1220", new ArrayList<>()));

            userService.addRoleToUser("Ginni", "ROLE_USER");
            userService.addRoleToUser("Ginni", "ROLE_ADMIN");
            userService.addRoleToUser("niks", "ROLE_ADMIN");
            userService.addRoleToUser("niks", "ROLE_USER");
        };
    }
}
