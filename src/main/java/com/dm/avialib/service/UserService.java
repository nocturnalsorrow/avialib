package com.dm.avialib.service;

import com.dm.avialib.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserByEmail(String email);

    User createUser(User user);

    User signUpUser(User user);

    User updateUser(User user);

    void deleteUserByEmail(String email);
}
