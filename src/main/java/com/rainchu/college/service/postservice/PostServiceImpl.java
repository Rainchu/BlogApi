package com.rainchu.college.service.postservice;

import com.rainchu.college.entity.Category;
import com.rainchu.college.entity.Post;
import com.rainchu.college.entity.User;
import com.rainchu.college.exception.NoResourceFoundException;
import com.rainchu.college.payloads.PostResponse;
import com.rainchu.college.repository.CategoryRepository;
import com.rainchu.college.repository.PostRepository;
import com.rainchu.college.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    public Post savePost(Post post,int userId,int cId) throws NoResourceFoundException {

        User user = this.userRepository.findById(userId).orElseThrow(() -> new NoResourceFoundException("No User Id Found"));
        Category category = this.categoryRepository.findById(cId).orElseThrow(() -> new NoResourceFoundException("No Category Id Found"));

        post.setUser(user);
        post.setCategory(category);
       // post.setPostImage("default.png");

         return this.postRepository.save(post);
    }

    @Override
    public PostResponse getPost(int pageNumber, int pageSize,String sortBy) {

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
        Page<Post> posts = this.postRepository.findAll(pageRequest);
        List<Post> postsContent = posts.getContent();

        PostResponse postResponse = new PostResponse();
        postResponse.setPostList(postsContent);
        postResponse.setTotalElement(posts.getTotalElements());
        postResponse.setPageNumber(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalPage(posts.getTotalPages());
        postResponse.setLastPage(posts.isLast());


        return postResponse;
    }

    @Override
    public Post updateById(Post post, int id) throws NoResourceFoundException {

        Post post1 = this.postRepository.findById(id).orElseThrow(() -> new NoResourceFoundException("No Id Found"));
        post1.setPostTitle(post.getPostTitle());
        post1.setPostContent(post.getPostContent());
        post1.setPostImage(post.getPostImage());
        post1.setCategory(post.getCategory());
        post1.setUser(post.getUser());

        return this.postRepository.save(post1);

    }

    @Override
    public void deleteById(int id) throws NoResourceFoundException {
        Post post = this.postRepository.findById(id).orElseThrow(() -> new NoResourceFoundException("No Id Found"));

        this.postRepository.deleteById(id);
    }

    @Override
    public Post getById(int id) throws NoResourceFoundException {
        return this.postRepository.findById(id).orElseThrow(()->new NoResourceFoundException("No Id Found"));
    }

    @Override
    public List<Post> getByCategoryName(int cId) throws NoResourceFoundException {

        Category category = this.categoryRepository.findById(cId).orElseThrow(() -> new NoResourceFoundException("Category Not Found"));

        return this.postRepository.findByCategory(category);
    }

    @Override
    public List<Post> getByUserName(int uId) throws NoResourceFoundException {
        User user = this.userRepository.findById(uId).orElseThrow(() -> new NoResourceFoundException("No User Found"));

        return this.postRepository.findByUser(user);
    }

    @Override
    public List<Post> findBySearch(String keyword) {

        return this.postRepository.findByPostTitleContaining(keyword);
    }


}
