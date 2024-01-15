package com.rainchu.college.service.comments;

import com.rainchu.college.entity.Comment;
import com.rainchu.college.exception.NoResourceFoundException;

import java.util.List;

public interface CommentService {

    Comment saveComment(Comment comment,int uId,int pId) throws NoResourceFoundException;

    List<Comment> getAllComment();

    Comment getById(int id);

    Comment deleteById(int id);

    List<Comment> getByUserNAme(int id);

    List<Comment> getByPostName(int id);

}
