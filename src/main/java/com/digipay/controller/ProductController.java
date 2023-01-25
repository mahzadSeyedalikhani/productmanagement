package com.digipay.controller;

import com.digipay.employee.Permission;
import com.digipay.employee.UserController;
import com.digipay.employee.UserControllerImplService;
import com.digipay.model.dto.CategoryDto;
import com.digipay.model.dto.ProductRequest;
import com.digipay.model.dto.ProductDto;
import com.digipay.model.entity.Category;
import com.digipay.model.entity.Product;
import com.digipay.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    public void employeeAccessCheck(String nationalId, String permission) throws Exception {
        UserControllerImplService userControllerImplService = new UserControllerImplService();
        UserController userControllerImplPort = userControllerImplService.getUserControllerImplPort();
        List<Permission> permissions = userControllerImplPort.getUserByNid(nationalId).getRole().getPermissions();

        List<String> permissionName = new ArrayList<>();
        for (Permission x : permissions) {
            permissionName.add(x.getTitle());
        }
        if (!permissionName.contains(permission)) {
            throw new Exception("Sorry you don't have required permission");
        }
        logger.info("Welcome, now you will redirecting to the {} operation", permission);
    }


    @PostMapping
    public void addProduct(@RequestBody ProductRequest productRequest) throws Exception {
        employeeAccessCheck(productRequest.getEmployeeNationalId(), "add");
        productService.addProduct(productRequest.getName(), productRequest.getProductQuantity(), productRequest.getCategories(),
                productRequest.getEmployeeNationalId(), productRequest.getPrice());
    }

    @DeleteMapping("{productId}")
    public void removeProduct(@PathVariable String productId, @RequestBody ProductRequest productRequest)
            throws Exception {
        employeeAccessCheck(productRequest.getEmployeeNationalId(), "remove");
        productService.removeProduct(productId, productRequest.getEmployeeNationalId());
    }

    @PatchMapping(value = "{productId}")
    public void updateProduct(@PathVariable String productId, @RequestBody ProductRequest productRequest) {
        productService.updateProduct(productId, productRequest.getName(), productRequest.getCategories(),
                productRequest.getPrice());
    }

    @GetMapping("{productId}")
    public ProductDto getProduct(@PathVariable String productId) {
        Product product = productService.getProduct(productId);

        ProductDto mapProductToProductDto = new ProductDto();
        mapProductToProductDto.setProductId(product.getProductId());
        mapProductToProductDto.setProductName(product.getProductName());
        mapProductToProductDto.setEmployeeNationalId(product.getEmployeeNationalId());
        mapProductToProductDto.setProductPrice(product.getProductPrice());
        mapProductToProductDto.setProductQuantity(product.getProductQuantity());

        Set<Category> categories = product.getCategories();
        Set<CategoryDto> categoryDtoSet = new HashSet<>();
        for(Category category: categories){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(category.getCategoryId());
            categoryDto.setCategoryName(category.getCategoryName());
            categoryDto.setActive(category.isActive());
            categoryDtoSet.add(categoryDto);
        }
        mapProductToProductDto.setCategories(categoryDtoSet);

        return mapProductToProductDto;
    }

    @GetMapping
    public List<ProductDto> getAllActiveProduct() {
        List<Product> allActiveProducts = productService.getAllActiveProduct();
        List<ProductDto> productDto = new ArrayList<>();

        for (Product product : allActiveProducts) {
            ProductDto mapping = new ProductDto();
            mapping.setProductId(product.getProductId());
            mapping.setProductName(product.getProductName());
            mapping.setEmployeeNationalId(product.getEmployeeNationalId());
            mapping.setProductPrice(product.getProductPrice());
            mapping.setProductQuantity(product.getProductQuantity());

            Set<Category> categories = product.getCategories();
            Set<CategoryDto> categoryDtoSet = new HashSet<>();
            for(Category category: categories){
                CategoryDto categoryDto = new CategoryDto();
                categoryDto.setCategoryId(category.getCategoryId());
                categoryDto.setCategoryName(category.getCategoryName());
                categoryDto.setActive(categoryDto.isActive());
                categoryDtoSet.add(categoryDto);
            }
            mapping.setCategories(categoryDtoSet);
            productDto.add(mapping);
        }
        return productDto;
    }
}
