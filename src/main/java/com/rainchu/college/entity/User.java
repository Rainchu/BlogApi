package com.rainchu.college.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uId;

    @NotNull
    @Column(length = 100)
    private String name;

    @NotNull
    @Email(message = "email is not valid")

    private String email;

    @NotNull
    @Min(message = "min 3 character",value = 3)
    @Max(value = 8,message = "max 8 character")
    private String password;


    @NotNull
    private String about;

    @OneToMany
    private List<Post> postList;

    @OneToMany
    private List<Comment> comments;

    public User() {
    }


    public User(int uId, String name, String email, String password, String about, List<Post> postList, List<Comment> comments) {
        this.uId = uId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.about = about;
        this.postList = postList;
        this.comments = comments;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
