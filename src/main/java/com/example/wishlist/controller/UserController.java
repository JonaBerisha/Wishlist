package com.example.wishlist.controller;

import com.example.wishlist.model.User;
import com.example.wishlist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/user")

public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    public UserController (UserService userService){
        this.userService = userService;
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password){
        User user = userService.login(email,password);
        if(user != null){
            return "redirect:/wishlist";
        }
        return "login";
    }
    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String name, @RequestParam String password, @RequestParam LocalDate birthDate){
        User user = userService.register(email, name, password, birthDate);
        if(user != null){
            return "redirect:/wishlist";
        }
        return "register";
    }
}
