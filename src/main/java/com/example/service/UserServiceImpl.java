package com.example.service;

import com.example.models.User;
import com.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public User getUserById(Long userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}