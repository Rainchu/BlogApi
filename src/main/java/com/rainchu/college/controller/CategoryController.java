package com.rainchu.college.controller;

import com.rainchu.college.apiresponse.ApiResponse;
import com.rainchu.college.entity.Category;
import com.rainchu.college.exception.NoResourceFoundException;
import com.rainchu.college.service.categoryservice.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCategory(@RequestBody Category category){

        if (category.getcNAme().equals("")){
            return ResponseEntity.ok("Please Provide Category Name");
        }

        categoryService.saveCategory(category);
        return ResponseEntity.ok("Added Successfully");
    }

    @PutMapping("update/{cId}")
    public ResponseEntity<String> updateById(@RequestBody Category category, @PathVariable("cId") int id) throws NoResourceFoundException {
        this.categoryService.updateById(category, id);

        return ResponseEntity.ok("Updated Successfully");
    }

    @DeleteMapping("delete/{cId}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("cId") int id) throws NoResourceFoundException {
        this.categoryService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse("Deletd Successfully",true), HttpStatus.OK);
    }

    @GetMapping("category/{cId}")
    public ResponseEntity<ApiResponse> getCategory(@PathVariable("cId") int id) throws NoResourceFoundException {
        this.categoryService.getById(id);

        return new ResponseEntity<>(new ApiResponse("Category Found Successfully",true),HttpStatus.OK);
    }

    @GetMapping("category")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> category = this.categoryService.getCategory();

        return ResponseEntity.ok(category);
    }
}
