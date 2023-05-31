package com.example.socialmediaapi.repository;

import com.example.socialmediaapi.dto.UserDto;
import com.example.socialmediaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDto findByEmail(String email);

    UserDto findByUsername(String user);

    boolean existsByEmail(String email);
}
