package com.example.esun.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "`ORDER`")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "ORDERID")
    private String orderid;

    @Column(name = "MEMBERID")
    private int memberid;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "PAYSTATUS")
    private boolean isPaid;
}
