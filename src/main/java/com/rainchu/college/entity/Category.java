package com.rainchu.college.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;

    private String cNAme;

    private String description;


    @OneToMany
    private List<Post> postList;



    public Category() {
    }

    public Category(int cId, String cNAme, String description,List<Post> postList) {
        this.cId = cId;
        this.cNAme = cNAme;
        this.description = description;
        this.postList = postList;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcNAme() {
        return cNAme;
    }

    public void setcNAme(String cNAme) {
        this.cNAme = cNAme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
