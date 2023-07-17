package com.example.dao;

import com.example.models.User;

import java.util.List;

public interface UserDao {
    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    User getUserById(Long userId);

    List<User> getAllUsers();
}
