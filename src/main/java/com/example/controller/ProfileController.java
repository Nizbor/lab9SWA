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
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private TeacherLessonService teacherLessonService;

    @GetMapping("/profile")
    public String profile(Authentication authentication) {
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        String role = userDetails.getAuthorities().iterator().next().getAuthority();

        if (role.equals("admin")) {
            return "redirect:/profile/pageAdmin";
        } else {
            return "redirect:/profile/pageUser";
        }
    }

    @GetMapping("/profile/pageAdmin")
    public String adminPage(){
        return "adminPage";
    }
    @GetMapping("/profile/pageUser")
    public String userPage(){
        return "userPage";
    }

    @GetMapping("/profile/getUser")
    @PreAuthorize("hasAuthority('admin')")
    public String getUser(Model model) {
        List<MyUser> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "mainPage/userList"; // Вернуть имя представления, которое нужно отобразить
    }
    @GetMapping("/profile/unList")
    public String unList(Model model){
        List<TeacherLesson> teacherLessons = teacherLessonService.getAllTeacherLesson();
        model.addAttribute("teacherLessons", teacherLessons);
        return "mainPage/unList";
    }
    @GetMapping("/profile/unListAdmin")
    public String unListAdmin(Model model){
        List<TeacherLesson> teacherLessons = teacherLessonService.getAllTeacherLesson();
        model.addAttribute("teacherLessons", teacherLessons);
        return "CRUD_teacher/unListAdmin";
    }



}
