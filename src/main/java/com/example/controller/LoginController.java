package com.example.controller;

import com.example.config.MyUserDetails;
import com.example.model.MyUser;
import com.example.model.TeacherLesson;
import com.example.service.Impl.UserServiceImpl;

import com.example.service.TeacherLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller//("/Login")
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public String Login() {
        return "mainPage/login";
    }

    @GetMapping("/")
    public String out(){
        return "redirect:/profile";
    }

    @GetMapping("/logout")
    public String logout(Authentication authentication) {
        if (authentication != null) {
            authentication.setAuthenticated(false);
        }
        return "/login?logout";
    }


    @GetMapping("/welcome")
    public String welcome(){
        return "mainPage/welcome";
    }

}
