package com.example.esun.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "`ORDERDETAIL`")
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemSn;

    @Column(name = "ORDERID")
    private String orderid;

    @Column(name = "PRODUCTID")
    private String productid;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "STANDPRICE")
    private int standprice;

    @Column(name = "ITEMPRICE")
    private int totalprice;
}
