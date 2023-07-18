package com.example.dao;

import com.example.models.User;

import java.util.List;

public interface UserDao {
    public User save(User user);

    public User update(User user);

    public void delete(Long userId);

    public User findById(Long userId);

    public List<User> findAll();

    void deleteById(Long id);
}
