package com.example.wishlist.controller;

import com.example.wishlist.model.User;
import com.example.wishlist.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/")

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
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session){
        User user = userService.login(email,password);
        if(user != null){
            session.setAttribute("user", user);
            return "redirect:/wishlist";
        }
        return "login";
    }
    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String name, @RequestParam String password, @RequestParam LocalDate birthDate, HttpSession session){
        User user = userService.register(email, name, password, birthDate);
        if(user != null){
            session.setAttribute("user", user);
            return "redirect:/wishlist";
        }
        return "register";
    }
}
