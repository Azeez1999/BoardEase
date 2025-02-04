package com.debug.backend.repository;

import com.debug.backend.entity.OrderProduct;
import com.debug.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Integer> {
    Product findByProductName(String productName);
}
