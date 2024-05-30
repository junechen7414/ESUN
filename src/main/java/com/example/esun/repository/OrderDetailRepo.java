package com.example.esun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.esun.entity.OrderDetail;
import com.example.esun.entity.Product;

public interface OrderDetailRepo extends JpaRepository<OrderDetail,Integer>{
    // List<Product> findByQuantityGreaterThan(int quantity);
}