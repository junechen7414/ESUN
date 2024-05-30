package com.example.esun.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.esun.entity.Product;
import com.example.esun.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin("http://localhost:8081")
public class ProductController {
    @Autowired    
    private ProductService productService;

    @PostMapping("/addProduct")    
    public Product postProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    } 
        
    @GetMapping("/showProduct")
    public List<Product> getProduct() {
        return productService.showProduct();
    }
    
}