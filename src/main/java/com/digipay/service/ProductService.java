package com.digipay.service;

import com.digipay.model.entity.Category;
import com.digipay.model.entity.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Product addProduct(String name, Set<String> category, String employeeNationalId);

    void removeProduct(String name, String employeeNationalId) throws Exception;

    void updateProduct(String productId, String name, Set<String> category);

    Product getProduct(String productId);

    List<Product> getAllActiveProduct();
}
