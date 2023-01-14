package com.digipay.repository;

import com.digipay.model.entity.Order;
import com.digipay.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long>{

}
