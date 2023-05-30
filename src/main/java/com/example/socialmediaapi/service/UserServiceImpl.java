package com.example.socialmediaapi.service;

import com.example.socialmediaapi.model.User;
import com.example.socialmediaapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.createUser(user).get();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers().get();
    }
}
