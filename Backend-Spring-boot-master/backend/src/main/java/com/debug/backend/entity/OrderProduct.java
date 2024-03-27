package com.debug.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderProduct")
public class OrderProduct {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int  qty;
    private String invoiceNumber;
    private double  price;
    private String userName;
    private int userID;
    private String date;
}
