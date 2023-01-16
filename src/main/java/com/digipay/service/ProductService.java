package com.digipay.service;

import com.digipay.model.entity.Product;
import java.util.List;
import java.util.Set;

public interface ProductService {

    Product addProduct(String name, int productCount, Set<String> category, String employeeNationalId, String price);

    void removeProduct(String name, String employeeNationalId) throws Exception;

    void updateProduct(String productId, String name, Set<String> category, String price);

    Product getProduct(String productId);

    List<Product> getAllActiveProduct();
}
