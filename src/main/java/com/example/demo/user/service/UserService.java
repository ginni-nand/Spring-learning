package com.example.demo.user.service;

import com.example.demo.user.domain.Role;
import com.example.demo.user.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String userName, String roleName);

    User getUser(String userName);

    List<User> getAllUser();

    List<Role> getAllRoles();
}
