package com.example.esun.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esun.entity.Product;
import com.example.esun.repository.ProductRepo;
@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> showProduct(){
        return productRepo.findByQuantityGreaterThan(0);
    }

    // ProductService.java
    public void updateProductStock(String productId, int quantity) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setQuantity(product.getQuantity() - quantity);
        productRepo.save(product);
    }

}