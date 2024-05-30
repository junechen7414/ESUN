package com.example.esun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esun.entity.Order;
import com.example.esun.entity.Product;

public interface OrderRepo extends JpaRepository<Order,String>{
    // List<Product> findByQuantityGreaterThan(int quantity);
}