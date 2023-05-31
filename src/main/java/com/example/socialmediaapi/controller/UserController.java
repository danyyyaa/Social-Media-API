package com.example.socialmediaapi.controller;

import com.example.socialmediaapi.dto.UserDto;
import com.example.socialmediaapi.model.User;
import com.example.socialmediaapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserDto createUser(@RequestBody @Valid UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public Collection<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/login")
    public ModelAndView showLoginForm() {
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView showRegistrationForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (userService.isUserEmailExists(user.getEmail())) {
            model.addAttribute("emailExists", true);
            return "register";
        }

        userService.registerUser(user);
        return "redirect:/login?registered";
    }
}
