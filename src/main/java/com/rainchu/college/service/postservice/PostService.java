package com.rainchu.college.service.postservice;

import com.rainchu.college.entity.Category;
import com.rainchu.college.entity.Post;
import com.rainchu.college.entity.User;
import com.rainchu.college.exception.NoResourceFoundException;
import com.rainchu.college.payloads.PostResponse;

import java.util.List;

public interface PostService {

    Post savePost(Post post,int userId,int cId) throws NoResourceFoundException;

    PostResponse getPost(int pageNumber, int pageSize,String sortBy);

    Post updateById(Post post,int id) throws NoResourceFoundException;

    void deleteById(int id) throws NoResourceFoundException;

    Post getById(int id) throws NoResourceFoundException;

    List<Post> getByCategoryName(int cId) throws NoResourceFoundException;

    List<Post> getByUserName(int uId) throws NoResourceFoundException;

    List<Post> findBySearch(String keyword);

}
