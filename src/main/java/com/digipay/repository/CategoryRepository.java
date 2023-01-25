package com.digipay.repository;

import com.digipay.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByCategoryName(String name);
    Set<Category> findByCategoryNameIn(Set<String> categories);



}

