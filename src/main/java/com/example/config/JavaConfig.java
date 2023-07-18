package com.example.config;

import com.example.dao.UserDao;
import com.example.dao.UserDaoImpl;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableTransactionManagement
public class JavaConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl(entityManager);
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory((EntityManagerFactory) entityManager.getEntityManagerFactory());
        return transactionManager;
    }
}