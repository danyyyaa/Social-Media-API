package com.example.socialmediaapi.service;

import com.example.socialmediaapi.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id) ;

    List<UserDto> getAllUsers();
}
