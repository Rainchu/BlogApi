package com.rainchu.college.repository;

import com.rainchu.college.entity.Comment;
import com.rainchu.college.entity.Post;
import com.rainchu.college.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findByUser(User user);
    List<Comment> findByPost(Post post);

}
