package com.example.socialmediaapi.dto;

import com.example.socialmediaapi.model.Role;
import lombok.*;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String email;

    private String password;

    @Singular
    private Collection<Role> roles;
}
