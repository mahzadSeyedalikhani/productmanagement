package com.digipay.repository;

import com.digipay.model.entity.OrderItem;
import com.digipay.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductId(String productId);

    Product findProductByActiveIsTrue();

    List<Product> findAllByActiveIsTrue();

    Product findByProductName(String productName);
    Boolean existsProductByProductName(String Name);
}
