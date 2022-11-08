package com.example.demo.user.service;

import com.example.demo.user.domain.Role;
import com.example.demo.user.domain.User;
import com.example.demo.user.repository.RoleRepository;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        // log.info("saving user {} to database", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        // log.info("saving role {} to database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        // log.info("Adding role {} to user {}", roleName, userName);
        User user = userRepository.findByUsername(userName);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String userName) {
        // log.info("fetching user {}", userName);
        return userRepository.findByUsername(userName);
    }

    @Override
    public List<User> getAllUser() {
        //log.info("fetching all users");
        return userRepository.findAll();
    }
}
