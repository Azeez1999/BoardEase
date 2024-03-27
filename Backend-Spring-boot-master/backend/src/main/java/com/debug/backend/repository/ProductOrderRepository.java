package com.debug.backend.repository;

import com.debug.backend.entity.Feedback;
import com.debug.backend.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<OrderProduct, Integer> {
    @Query("SELECT DISTINCT p.invoiceNumber FROM OrderProduct p")
    List<Long> findDistinctInvoiceNumbers();

    @Query("SELECT DISTINCT p.invoiceNumber FROM OrderProduct p WHERE p.userID = :userID")
    List<Long> findDistinctUserID(@Param("userID") int userID);

    @Query("SELECT DISTINCT p.invoiceNumber FROM OrderProduct p")
    List<String> findInvoiceNumber();

    List<OrderProduct> findByInvoiceNumber(String invoiceNumber);

    @Query("SELECT p.invoiceNumber As InvoiceNumber, p.userName, p.date, SUM(p.price * p.qty) AS totalSale FROM OrderProduct p GROUP BY p.invoiceNumber, p.userName, p.date")
    List<Object[]> findTotalOrder();
}
