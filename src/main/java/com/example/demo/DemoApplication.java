package com.example.demo;

import com.example.demo.user.domain.Role;
import com.example.demo.user.domain.User;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        try {
            SpringApplication.run(DemoApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(String... args) throws Exception {
        userService.saveRole(new Role(null, "ROLE_USER"));
        userService.saveRole(new Role(null, "ROLE_ADMIN"));
        userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
        userService.saveRole(new Role(null, "ROLE_MANAGER"));

        userService.saveUser(new User(null, "Ginni", "Gin1220", "gins@1220", new ArrayList<>()));
        userService.saveUser(new User(null, "niks", "niks1220", "niks@1220", new ArrayList<>()));
        userService.saveUser(new User(null, "rish", "rish1220", "rish@1220", new ArrayList<>()));
        userService.saveUser(new User(null, "bins", "bins1220", "bins@1220", new ArrayList<>()));

        userService.addRoleToUser("Gin1220", "ROLE_USER");
        userService.addRoleToUser("Gin1220", "ROLE_ADMIN");
        userService.addRoleToUser("niks1220", "ROLE_ADMIN");
        userService.addRoleToUser("niks1220", "ROLE_USER");

    }

}
