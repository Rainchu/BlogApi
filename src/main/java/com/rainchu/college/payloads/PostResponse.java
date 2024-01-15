package com.rainchu.college.payloads;

import com.rainchu.college.entity.Post;

import java.util.List;

public class PostResponse {

    private List<Post> postList;



    private int pageSize;

    private int pageNumber;

    private long totalElement;

    private int totalPage;
    private boolean lastPage;


    public PostResponse() {
    }

    public PostResponse(List<Post> postList, int pageSize, int pageNumber, long totalElement, int totalPage, boolean lastPage) {
        this.postList = postList;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.totalElement = totalElement;
        this.totalPage = totalPage;
        this.lastPage = lastPage;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }
}
