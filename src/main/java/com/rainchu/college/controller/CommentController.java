package com.rainchu.college.controller;

import com.rainchu.college.entity.Comment;
import com.rainchu.college.exception.NoResourceFoundException;
import com.rainchu.college.service.comments.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;


    @PostMapping("/user/{uId}/post/{pId}/comments")
    public Comment saveComment(@PathVariable("uId") int id, @PathVariable("pId") int pid, @RequestBody Comment comment) throws NoResourceFoundException {
        return this.commentService.saveComment(comment, id, pid);
    }

}
