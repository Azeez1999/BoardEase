package com.debug.backend.service;

import com.debug.backend.entity.OrderProduct;
import com.debug.backend.entity.Product;
import com.debug.backend.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {
    @Autowired
    private ProductOrderRepository productOrderRepository;

    public List<OrderProduct> saveOrderProducts(List<OrderProduct> orderProducts) {
        return productOrderRepository.saveAll(orderProducts);
    }

    public long countUniqueInvoiceNumbers() {
        List<Long> uniqueInvoiceNumbers = productOrderRepository.findDistinctInvoiceNumbers();
        return uniqueInvoiceNumbers.size();
    }

    public int getDistinctInvoiceNumbersByUserId(int userId) {
        List<Long> uniqueUserID = productOrderRepository.findDistinctUserID(userId);
        return uniqueUserID.size();
    }

    public List<String> countTotalInvoiceNumber() {
        return productOrderRepository.findInvoiceNumber();
    }

    public List<OrderProduct> getOrderProductByInvoiceNumber(String invoiceNumber) {
        List<OrderProduct> orders = productOrderRepository.findByInvoiceNumber(invoiceNumber);

        return orders;
    }

    public List<Object[]> findTotalOrder() {
        return productOrderRepository.findTotalOrder();
    }
}
