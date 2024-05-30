package com.example.esun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esun.entity.Product;

public interface ProductRepo extends JpaRepository<Product,String>{
    List<Product> findByQuantityGreaterThan(int quantity);
}