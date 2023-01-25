package com.digipay.service.impl;

import com.digipay.model.entity.Category;
import com.digipay.repository.CategoryRepository;
import com.digipay.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(String categoryName, String parentCategory) {
        Category parent = null;
        if (parentCategory != null) {
            parent = categoryRepository.findCategoryByCategoryName(parentCategory);

        }
        return categoryRepository.save(new Category(categoryName, parent, UUID.randomUUID().toString()));
    }
}
