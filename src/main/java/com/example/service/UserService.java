package com.example.service;

import com.example.model.MyUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    MyUser addUser(String login, String password, String email);
    MyUser addUser(MyUser user);
    void delete(Integer id);
    void phoenix(Integer id);
    MyUser getById(Integer id);
    List<MyUser> getAllUsers();
    MyUser updateUser(MyUser user);

    //MyUser getByUsername(String login);
    Boolean doLog(String login, String password);
    String findRoleByLogin(String login);
    MyUser getByEmail(String email);

    boolean testLoginAndEmail(String login, String email);
}
