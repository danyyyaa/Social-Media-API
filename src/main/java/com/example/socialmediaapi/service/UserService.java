package com.example.socialmediaapi.service;

import com.example.socialmediaapi.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id) ;

    List<User> getAllUsers();
}
