package com.banking.pii.compliance.controller;

import com.banking.pii.compliance.model.User;
import com.banking.pii.compliance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Exposes all user data, including PII, without authentication or masking
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
}