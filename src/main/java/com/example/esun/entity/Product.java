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
@Table(name = "PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "PRODUCTID")
    private String id;

    @Column(name = "PRODUCTNAME")
    private String name;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "QUANTITY")
    private int quantity;
}
