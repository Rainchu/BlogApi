package com.rainchu.college.service.categoryservice;

import com.rainchu.college.entity.Category;
import com.rainchu.college.exception.NoResourceFoundException;

import java.util.List;

public interface CategoryService {

    public Category saveCategory(Category category);

     Category getById(int id) throws NoResourceFoundException;

     void deleteById(int id) throws NoResourceFoundException;

     List<Category> getCategory();

     Category updateById(Category category, int id) throws NoResourceFoundException;


}
