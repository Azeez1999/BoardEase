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
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String productName;
    private String imageURL;
    private String description;
    private double purchasePrice;
    private double sellingPrice;
    private double quantity;
    public Object getProductName() {
      return null;
    }
    public void setProductName(Object productName2) {
    }
    public Object getDescription() {
      return null;
    }
    public void setDescription(Object description2) {
    }
    public Object getSellingPrice() {
      return null;
    }
    public void setSellingPrice(Object sellingPrice2) {
    }
    public Object getPurchasePrice() {
      return null;
    }
    public void setPurchasePrice(Object purchasePrice2) {
    }
}
