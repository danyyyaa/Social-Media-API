package com.example.socialmediaapi.service;

import com.example.socialmediaapi.dto.UserDto;
import com.example.socialmediaapi.exception.UserNotFoundException;
import com.example.socialmediaapi.model.User;
import com.example.socialmediaapi.mapper.UserMapper;
import com.example.socialmediaapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.socialmediaapi.mapper.UserMapper.mapToUser;
import static com.example.socialmediaapi.mapper.UserMapper.mapToUserDto;

@Service
@RequiredArgsConstructor
@Primary
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        return mapToUserDto(userRepository.save(mapToUser(userDto)));
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public void registerUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);

        userRepository.save(user);
    }

    @Override
    public boolean isUserEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
