package com.example.esun.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esun.entity.Order;
import com.example.esun.repository.OrderRepo;
@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order saveOrder(Order order){
        return orderRepo.save(order);
    }

    // public List<Product> showProduct(){
    //     return productRepo.findByQuantityGreaterThan(0);
    // }

}