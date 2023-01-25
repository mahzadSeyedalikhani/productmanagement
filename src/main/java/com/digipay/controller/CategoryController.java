package com.digipay.controller;

import com.digipay.model.dto.CategoryDto;
import com.digipay.model.dto.CategoryRequest;
import com.digipay.model.entity.Category;
import com.digipay.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category addCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.addCategory(categoryRequest.getCategoryName(), categoryRequest.getParentCategory());
    }
}
