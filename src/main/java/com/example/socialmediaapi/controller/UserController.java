package com.example.socialmediaapi.controller;

import com.example.socialmediaapi.dto.UserDto;
import com.example.socialmediaapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public UserDto createUser(@RequestBody @Valid UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping()
    public Collection<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
