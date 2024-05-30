package com.example.esun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esun.entity.Product;

public interface ProductRepo extends JpaRepository<Product,String>{
}