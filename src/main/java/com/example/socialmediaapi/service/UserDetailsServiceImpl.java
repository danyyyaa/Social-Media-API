package com.example.socialmediaapi.service;

import com.example.socialmediaapi.model.User;
import com.example.socialmediaapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.socialmediaapi.mapper.UserMapper.mapToUser;

@Service
public class UserDetailsServiceImpl /*implements UserDetailsService*/ {

    /*@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws RuntimeException {
        User user = mapToUser(userRepository.findByEmail(email));
        if (user == null) {
            throw new RuntimeException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }*/
}
