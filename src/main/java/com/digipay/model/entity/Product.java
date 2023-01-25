package com.digipay.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
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

    @Column(name = "product_Quantity")
    private int productQuantity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PRODUCT_CATEGORY", joinColumns ={@JoinColumn(name = "product_id")},
                   inverseJoinColumns = {@JoinColumn (name = "category_id")})
    private Set<Category> categories;

    @Column(name= "employee_creator")
    private String employeeNationalId;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "active_status")
    private boolean active= true;

    public Product() {
    }

    public Product(String productName, int productQuantity, Set<Category> categories, String employeeNationalId,
                   String productId, BigDecimal productPrice, boolean active){
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.categories = categories;
        this.employeeNationalId = employeeNationalId;
        this.productId = productId;
        this.productPrice = productPrice;
        this.active = active;
    }

    public Product(String productName, int productQuantity, Set<Category> categories, String employeeNationalId,
                   String productId, BigDecimal productPrice){
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.categories = categories;
        this.employeeNationalId = employeeNationalId;
        this.productId = productId;
        this.productPrice = productPrice;
    }
}
