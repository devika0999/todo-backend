package com.nestdigital.todo_backend.controller;

import com.nestdigital.todo_backend.dao.PostDao;
import com.nestdigital.todo_backend.model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {

    @Autowired
    private PostDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addpost",consumes = "application/json",produces = "application/json")
    public String addPost(@RequestBody PostModel post)
    {
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        post.setPostdate(currentdate);
        System.out.println(post.toString());
        dao.save(post);
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/view",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> ViewSingle(@RequestBody PostModel post)
    {
        return (List<Map<String, String>>) dao.viewAllSingle(post.getUserid());
    }
}
