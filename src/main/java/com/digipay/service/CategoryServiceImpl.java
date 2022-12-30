package com.digipay.service;

import com.digipay.model.entity.Category;

public interface CategoryServiceImpl {
    Category addCategory(String CategoryName, String parentCategory);
}
