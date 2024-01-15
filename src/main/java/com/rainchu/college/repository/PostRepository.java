package com.rainchu.college.repository;

import com.rainchu.college.entity.Category;
import com.rainchu.college.entity.Post;
import com.rainchu.college.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByCategory(Category category);
    List<Post> findByUser(User user);

    List<Post> findByPostTitleContaining(String search);

}
