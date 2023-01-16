package com.digipay.service.impl;

import com.digipay.model.entity.Category;
import com.digipay.model.entity.Product;
import com.digipay.repository.CategoryRepository;
import com.digipay.repository.ProductRepository;
import com.digipay.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
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
    public Product addProduct(String name, int productCount, Set<String> category,
                              String employeeNationalId, String price){

        if(productRepository.existsProductByProductName(name)){
            Product existingProduct = productRepository.findByProductName(name);
            int currentQuantity = existingProduct.getProductCount();
            int updatedQuantity = currentQuantity + productCount;
            existingProduct.setProductCount(updatedQuantity);
            return productRepository.save(existingProduct);
        }else {
            System.out.println("sorry");
            Set<Category> categories = categoryRepository.findByCategoryNameIn(category);
            BigDecimal productPrice = new BigDecimal(price);
            return productRepository.save(new Product(name, productCount, categories, employeeNationalId, UUID.randomUUID().toString(), productPrice));
        }
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
    public void updateProduct(String productId, String name, Set<String> category, String price) {
        Product updatableProduct = productRepository.findByProductId(productId);
        BigDecimal productPrice = new BigDecimal(price);
        if(name != null){
            updatableProduct.setProductName(name);
        }
        if(category!=null){
            Set<Category> categorySet = categoryRepository.findByCategoryNameIn(category);
            updatableProduct.setCategories(categorySet);
        }
        if(price != null) {
            updatableProduct.setProductPrice(productPrice);
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
