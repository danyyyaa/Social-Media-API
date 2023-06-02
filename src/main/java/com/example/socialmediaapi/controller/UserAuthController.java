package com.example.socialmediaapi.controller;

import com.example.socialmediaapi.dto.UserDto;
import com.example.socialmediaapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users/auth")
public class UserAuthController {

    private final UserService userService;

    @GetMapping("/register")
    public String newUser(@ModelAttribute("user") UserDto user) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserDto user) {
        userService.createUser(user);
        return "redirect:/users/auth/successfulRegister";
    }

    @GetMapping("/successfulRegister")
    public String successfulRegister() {
        return "successfulRegister";
    }

    @GetMapping("/signin")
    public String signIn(@ModelAttribute("user") UserDto user) {
        return "signin";
    }

    @PostMapping("/signin")
    public String signInPost(@ModelAttribute("user") UserDto user) {
        return "redirect:/users/auth/successfulSignIn";
    }

    @GetMapping("/successfulSignIn")
    public String successfulSignIn() {
        return "successfulSignIn";
    }
}
