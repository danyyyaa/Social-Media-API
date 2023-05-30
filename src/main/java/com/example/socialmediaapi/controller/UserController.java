package com.example.socialmediaapi.controller;

import com.example.socialmediaapi.model.User;
import com.example.socialmediaapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
