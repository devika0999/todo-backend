package com.nestdigital.todo_backend.controller;

import com.nestdigital.todo_backend.dao.UserDao;
import com.nestdigital.todo_backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private  UserDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signup",consumes = "application/json",produces = "application/json")
    public String signUp(@RequestBody UserModel user)
    {
        System.out.println(user.toString());
        dao.save(user);
        return "{Status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public  List<UserModel> Login(@RequestBody UserModel user)
    {
        return (List<UserModel>) dao.SignUp(user.getEmail(),user.getPassword());
    }
}
