package com.rainchu.college.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;

    private String postTitle;

    private String postContent;

    private String postImage;


    @OneToMany
    private List<Comment> comments;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    public Post() {
    }

    public Post(int pId, String postTitle, String postContent, String postImage, List<Comment> comments, User user, Category category) {
        this.pId = pId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postImage = postImage;
        this.comments = comments;
        this.user = user;
        this.category = category;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pId=" + pId +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postImage='" + postImage + '\'' +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
