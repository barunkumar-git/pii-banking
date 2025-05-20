package com.banking.pii.compliance.service;

import com.banking.pii.compliance.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private List<User> users = new ArrayList<>();

    public List<User> findAllUsers() {
        // Logging sensitive PII data
        for (User user : users) {
            logger.info("User found: Name={}, Email={}, SSN={}", 
                user.getName(), user.getEmail(), user.getSsn());
        }
        return users;
    }

    public void addUser(User user) {
        // Logging sensitive PII data on user creation
        logger.info("Adding user: {}", user.toString());
        users.add(user);
    }
}