package com.rainchu.college.controller;

import com.rainchu.college.apiresponse.ApiResponse;
import com.rainchu.college.entity.Post;
import com.rainchu.college.exception.NoResourceFoundException;
import com.rainchu.college.payloads.PostResponse;
import com.rainchu.college.service.fileservice.FileService;
import com.rainchu.college.service.postservice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    FileService fileService;

    @Value("${project.image}")
    String path;

    @PostMapping("/save/user/{uId}/category/{cId}/post")
    public ResponseEntity<String> savePost(@RequestBody Post post,@PathVariable("uId") int uId,@PathVariable("cId") int cId) throws NoResourceFoundException {
        if (post.getPostTitle().equals("")) return ResponseEntity.ok("Please Provide Title");
        if (post.getPostContent().equals("")) return ResponseEntity.ok("Please Provide Content");
      /*  if (post.getPostImage().equals("")) return ResponseEntity.ok("Please Provide Image");
        if (post.getCategory()== null) return ResponseEntity.ok("Please Provide Category");
        if (post.getUser() == null) return ResponseEntity.ok("Please Login To Post");
*/
        postService.savePost(post,uId,cId);

        return ResponseEntity.ok("Post Added Successfully");
    }

    @GetMapping("/post")
    public ResponseEntity<PostResponse> getPostAllPost(
            @RequestParam(value = "pageNumber",defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
            @RequestParam(value = "sortBy",defaultValue = "pId",required = false) String sortBy
    ){
        PostResponse post = postService.getPost(pageNumber, pageSize,sortBy);
        return new ResponseEntity<>(post, HttpStatus.OK);

    }

    @PutMapping("/update/{pId}")
    public ResponseEntity<Post> updateById(@RequestBody Post post,@PathVariable("pId") int id) throws NoResourceFoundException {
        Post post1 = this.postService.updateById(post, id);

        return new ResponseEntity<>(post1,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{pId}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("pId") int id) throws NoResourceFoundException {
        this.postService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse("Deleted Successfully",true),HttpStatus.OK);
    }

    @GetMapping("/getpost/{pId}")
    public ResponseEntity<Post> getPostById(@PathVariable("pId") int id) throws NoResourceFoundException {
        Post post = this.postService.getById(id);

        return ResponseEntity.ok(post);
    }

    @GetMapping("/bycategory/{cId}")
    public ResponseEntity<List<Post>> getByCategoryName(@PathVariable("cId") int id) throws NoResourceFoundException {
        List<Post> byCategoryName = this.postService.getByCategoryName(id);

        return new ResponseEntity<>(byCategoryName,HttpStatus.OK);
    }

    @GetMapping("/byuser/{uId}")
    public ResponseEntity<List<Post>> getByUserName(@PathVariable("uId") int id) throws NoResourceFoundException {
        List<Post> byUserName = this.postService.getByUserName(id);

        return new ResponseEntity<>(byUserName,HttpStatus.OK);
    }

    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<Post>> findBySearch(@PathVariable("keywords") String keywords){
        List<Post> bySearch = this.postService.findBySearch(keywords);
        return new ResponseEntity<>(bySearch,HttpStatus.OK);
    }

    @PostMapping("/post/image/upload/{pId}")
    public ResponseEntity<Post> uploadImage(
            @RequestParam("image")MultipartFile file,
            @PathVariable("pId") int id
            ) throws IOException, NoResourceFoundException {
        String uploadImage = this.fileService.uploadImage(path, file);
        Post post = this.postService.getById(id);
        post.setPostImage(uploadImage);
        this.postService.updateById(post,id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

}
