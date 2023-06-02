package com.example.socialmediaapi.dto;

import com.example.socialmediaapi.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String email;

    private String password;

    //private Set<Role> roles;
}
