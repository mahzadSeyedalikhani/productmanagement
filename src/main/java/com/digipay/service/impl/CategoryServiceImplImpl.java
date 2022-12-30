package com.digipay.service.impl;

import com.digipay.model.entity.Category;
import com.digipay.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryServiceImplImpl implements com.digipay.service.CategoryServiceImpl {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImplImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(String categoryName, String parentCategory) {
        Category parent = null;
        if (parentCategory != null) {
            parent = categoryRepository.findByCategoryName(parentCategory);
        }
        return categoryRepository.save(new Category(categoryName, parent, UUID.randomUUID().toString()));
    }
}
