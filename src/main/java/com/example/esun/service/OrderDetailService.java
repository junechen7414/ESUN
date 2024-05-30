package com.example.esun.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.esun.entity.OrderDetail;
import com.example.esun.repository.OrderDetailRepo;
@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    public void saveOrderDetail(List<OrderDetail> orderDetails){
        for (OrderDetail orderDetail : orderDetails) {
            orderDetailRepo.save(orderDetail);
        }
    }

    public List<OrderDetail> showOrderDetail(){
        return orderDetailRepo.findAll();
    }

}