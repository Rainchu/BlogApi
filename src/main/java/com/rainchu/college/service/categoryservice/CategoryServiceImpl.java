package com.rainchu.college.service.categoryservice;

import com.rainchu.college.entity.Category;
import com.rainchu.college.exception.NoResourceFoundException;
import com.rainchu.college.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getById(int id) throws NoResourceFoundException {


        return categoryRepository.findById(id).orElseThrow(() -> new NoResourceFoundException("No Category Id Found"));
    }

    @Override
    public void deleteById(int id) throws NoResourceFoundException {
        categoryRepository.findById(id).orElseThrow(()->new NoResourceFoundException("No Category Id Found"));

        categoryRepository.deleteById(id);

    }

    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateById(Category category, int id) throws NoResourceFoundException {
        Category category1 = categoryRepository.findById(id).orElseThrow(() -> new NoResourceFoundException("No Category Id Found"));

        category1.setcNAme(category.getcNAme());
        category1.setDescription(category.getDescription());


        return categoryRepository.save(category1);
    }
}
