package com.example.esun.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.esun.entity.Order;
import com.example.esun.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin("http://localhost:8081")
public class OrderController {
    @Autowired    
    private OrderService orderService;

    @PostMapping("/addOrder")
    public Order postOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    } 
        
    // @GetMapping("/showProduct")
    // public List<Product> getProduct() {
    //     return productService.showProduct();
    // }
    
}