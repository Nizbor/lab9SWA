package com.example.controller;

import com.example.model.MyUser;
import com.example.service.Impl.UserServiceImpl;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register() {
        return "mainPage/register";
    }

    @PostMapping("/register")
    public String reg(@ModelAttribute MyUser user)

            //@RequestParam String login, @RequestParam String password, @RequestParam String email)
            {
        if (!userService.testLoginAndEmail(user.getLogin(), user.getEmail())){
            userService.addUser(user);
            return "redirect:/welcome";
        }else{
            return "redirect:/register?error";
        }
    }

}
