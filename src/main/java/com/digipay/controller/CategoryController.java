package com.digipay.controller;

import com.digipay.model.dto.CategoryAddRequest;
import com.digipay.model.entity.Category;
import com.digipay.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;
    @Autowired
    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @PostMapping
    public Category addCategory(@RequestBody CategoryAddRequest categoryAddRequest){
        return categoryServiceImpl.addCategory(categoryAddRequest.getCategoryName(),
                categoryAddRequest.getParentCategory());
    }

}
