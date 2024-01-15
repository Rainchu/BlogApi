package com.rainchu.college.entity;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coId;

    private String commentContent;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;


    public Comment() {
    }

    public Comment(int coId, String commentContent, User user, Post post) {
        this.coId = coId;
        this.commentContent = commentContent;
        this.user = user;
        this.post = post;

    }

    public int getCoId() {
        return coId;
    }

    public void setCoId(int coId) {
        this.coId = coId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }




}
