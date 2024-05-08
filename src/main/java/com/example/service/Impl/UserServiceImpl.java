package com.example.service.Impl;

import com.example.model.MyUser;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.config.MyUserDetails;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<MyUser> user = userRepository.findByLogin(login);
        return user.map(MyUserDetails::new)
                .orElse(null);
    }



    @Override
    public MyUser addUser(String login, String password, String email) {
        MyUser user = new MyUser(login, password, email);
        return userRepository.save(user);
    }

    @Override
    public MyUser addUser(MyUser user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.softDelete(id);
    }

    @Override
    public void phoenix(Integer id) {
        userRepository.phoenix(id);
    }

    @Override
    public MyUser getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<MyUser> getAllUsers() {
        return (List<MyUser>) userRepository.findAll();
    }

    @Override
    public MyUser updateUser(MyUser user) {
        return userRepository.save(user);
    }

//    @Override
//    public MyUser getByUsername(String login) {
//        return userRepository.findByLogin(login);
//    }

    @Override
    public Boolean doLog(String login, String password) {
        return loadUserByUsername(login) != null && loadUserByUsername(login).getPassword().equals(password);
    }

    public boolean testLoginAndEmail(String login, String email){
        return loadUserByUsername(login) != null || getByEmail(email)!= null;
    }

    @Override
    public String findRoleByLogin(String login) {
        return userRepository.findRoleByLogin(login).getRole();
    }

    @Override
    public MyUser getByEmail(String email) {
        return userRepository.findByEmail(email);
    }



}

