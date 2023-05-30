package com.example.socialmediaapi.repository;

import com.example.socialmediaapi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> createUser(User user);

    Optional<User> getUserById(Long id);

    Optional<List<User>> getAllUsers();
}
