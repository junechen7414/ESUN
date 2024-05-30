package com.example.esun.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.esun.entity.OrderDetail;
import com.example.esun.service.OrderDetailService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin("http://localhost:8081")
public class OrderDetailController {
    @Autowired    
    private OrderDetailService orderDetailService;

    @PostMapping("/addOrderDetail")
    public void postOrderDetail(@RequestBody List<OrderDetail> orderDetail){
        orderDetailService.saveOrderDetail(orderDetail);
    } 
        
    @GetMapping("/showOrderDetail")
    public List<OrderDetail> getOrderDetail() {
        return orderDetailService.showOrderDetail();
    }
    
}