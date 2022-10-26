package com.nestdigital.todo_backend.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class PostModel {

    @Id
    @GeneratedValue

    private int id;
    private int userid;
    private String post;
    private String postdate;

    public PostModel(int id, int userid, String post, String postdate) {
        this.id = id;
        this.userid = userid;
        this.post = post;
        this.postdate = postdate;
    }

    public PostModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }
}
