package com.example.socialmediaapi.mapper;

import com.example.socialmediaapi.dto.UserDto;
import com.example.socialmediaapi.model.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .username(userDto.getUsername())
                .build();
    }

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .username(user.getUsername())
                .build();
    }
}
