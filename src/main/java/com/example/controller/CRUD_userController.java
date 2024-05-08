package com.example.controller;

import com.example.model.MyUser;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/CRUD")
@PreAuthorize("hasAuthority('admin')")
public class CRUD_userController {

    @Autowired
    private UserService userService;

    @GetMapping("/edit")
    public String edit(@RequestParam Integer id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "CRUD_user/editUser";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute MyUser user){
        if (userService.testLoginAndEmail(user.getLogin(), user.getEmail())){
            return "redirect:/profile/getUser?error";
        }else {
            MyUser empUser = userService.getById(user.getId());
            if (!user.getLogin().isEmpty()) empUser.setLogin(user.getLogin());
            if (!user.getPassword().isEmpty()) empUser.setPassword(user.getPassword());
            if (!user.getEmail().isEmpty()) empUser.setEmail(user.getEmail());
            if (!user.getRole().isEmpty()) empUser.setRole(user.getRole());
            userService.updateUser(empUser);
            return "redirect:/profile/getUser";
        }
    }

    @GetMapping("/create")
    public String create(){
        return "CRUD_user/createUser";
    }
    @PostMapping("/create")
    public String createUser(@ModelAttribute MyUser user){
        if (!userService.testLoginAndEmail(user.getLogin(), user.getEmail())){
            userService.addUser(user);
            return "redirect:/profile/getUser";
        }else{
            return "redirect:/CRUD/create?error";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        if(userService.getById(id).isDeleted()){
            userService.phoenix(id);
        }else{
            userService.delete(id);
        }
        return "redirect:/profile/getUser";
    }
}
