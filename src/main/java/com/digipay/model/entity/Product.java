package com.digipay.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Set;

@Setter
@Getter
@ToString
@Entity
@Table(name= "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    @Column(name= "product_name")
    private String productName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PRODUCT_CATEGORY", joinColumns ={@JoinColumn(name = "product_id")},
                   inverseJoinColumns = {@JoinColumn (name = "category_id")})
    private Set<Category> categories;

    @Column(name= "employee_creator")
    private String employeeNationalId;

    @Column(name = "active_status")
    private boolean active= true;

    public Product() {
    }

    public Product(String productName, Set<Category> categories, String employeeNationalId,
                   String productId, boolean active){
        this.productName = productName;
        this.categories = categories;
        this.employeeNationalId = employeeNationalId;
        this.productId = productId;
        this.active = active;
    }

    public Product(String productName, Set<Category> categories, String employeeNationalId,
                   String productId){
        this.productName = productName;
        this.categories = categories;
        this.employeeNationalId = employeeNationalId;
        this.productId = productId;
    }
}
