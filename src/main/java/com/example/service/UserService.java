package com.example.service;

import com.example.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User saveUser(User user);
    void deleteById(Long id);
}
