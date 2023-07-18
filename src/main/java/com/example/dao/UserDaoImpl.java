package com.example.dao;

import com.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        User user = entityManager.find(User.class, userId);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User getUserById(Long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM com.example.models.User u", User.class).getResultList();
    }
}