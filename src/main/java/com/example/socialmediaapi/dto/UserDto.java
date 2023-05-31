package com.example.socialmediaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private final Long id;

    private final String username;

    private final String email;

    private String password;
}
