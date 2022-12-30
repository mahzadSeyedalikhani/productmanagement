package com.digipay.service.impl;

import com.digipay.model.entity.Category;
import com.digipay.model.entity.Product;
import com.digipay.repository.CategoryRepository;
import com.digipay.repository.ProductRepository;
import com.digipay.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.rmi.AccessException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product addProduct(String name, Set<String> category, String employeeNationalId){
        Set<Category> categories = categoryRepository.findByCategoryNameIn(category);
        return productRepository.save(new Product(name,categories, employeeNationalId, UUID.randomUUID().toString()));
    }

    @Transactional
    @Override
    public void removeProduct(String productId, String employeeNationalId) throws Exception {
        String creatorEmployeeNid = productRepository.findByProductId(productId).getEmployeeNationalId();
        if(!creatorEmployeeNid.equals(employeeNationalId)){
           throw new AccessException("Sorry just the person who creates a product has access to remove it");
        }
        Product removableProduct = productRepository.findByProductId(productId);
        removableProduct.setActive(false);
        productRepository.save(removableProduct);
    }

    @Transactional
    @Override
    public void updateProduct(String productId, String name, Set<String> category) {
        Product updatableProduct = productRepository.findByProductId(productId);
        if(name != null){
            updatableProduct.setProductName(name);
        }
        if(category!=null){
            Set<Category> categorySet = categoryRepository.findByCategoryNameIn(category);
            updatableProduct.setCategories(categorySet);
        }
        productRepository.save(updatableProduct);
    }

    @Override
    public Product getProduct(String productId) {
        return productRepository.findByProductId(productId);



    }

    @Override
    public List<Product> getAllActiveProduct(){
        return productRepository.findAllByActiveIsTrue();
    }
}
