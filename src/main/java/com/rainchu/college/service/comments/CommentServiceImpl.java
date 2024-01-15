package com.rainchu.college.service.comments;

import com.rainchu.college.entity.Comment;
import com.rainchu.college.entity.Post;
import com.rainchu.college.entity.User;
import com.rainchu.college.exception.NoResourceFoundException;
import com.rainchu.college.repository.CommentRepository;
import com.rainchu.college.repository.PostRepository;
import com.rainchu.college.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Comment saveComment(Comment comment,int uId,int pId) throws NoResourceFoundException {

        Post post = this.postRepository.findById(pId).orElseThrow(() -> new NoResourceFoundException("No Post Found"));
        User user = this.userRepository.findById(uId).orElseThrow(() -> new NoResourceFoundException("No User fOund"));

        comment.setUser(user);
        comment.setPost(post);

        return this.commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllComment() {
        return null;
    }

    @Override
    public Comment getById(int id) {
        return null;
    }

    @Override
    public Comment deleteById(int id) {
        return null;
    }

    @Override
    public List<Comment> getByUserNAme(int id) {
        return null;
    }

    @Override
    public List<Comment> getByPostName(int id) {
        return null;
    }
}
