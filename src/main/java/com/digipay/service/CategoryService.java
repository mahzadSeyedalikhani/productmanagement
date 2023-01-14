package com.digipay.service;

import com.digipay.model.entity.Category;

public interface CategoryService {
    Category addCategory(String CategoryName, String parentCategory);
}
