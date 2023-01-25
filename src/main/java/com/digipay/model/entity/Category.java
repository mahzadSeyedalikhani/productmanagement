package com.digipay.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name= "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name= "category_name")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name= "parent_category")
    private Category parentCategory;

    @Column(name = "active_status")
    private boolean active = true;

    public Category() {

    }

    public Category(String categoryName, Category parentCategory, String categoryId){
        this.categoryName = categoryName;
        this.parentCategory = parentCategory;
        this.categoryId = categoryId;
    }


    public Category(String categoryName, Category parentCategory, String categoryId,
                    boolean active){
        this.categoryName = categoryName;
        this.parentCategory = parentCategory;
        this.categoryId = categoryId;
        this.active = active;
    }
}
