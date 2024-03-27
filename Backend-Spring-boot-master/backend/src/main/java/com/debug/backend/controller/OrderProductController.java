package com.debug.backend.controller;

import com.debug.backend.entity.OrderProduct;
import com.debug.backend.entity.Product;
import com.debug.backend.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderProductController {

    @Autowired
    private ProductOrderService productOrderService;

    @PostMapping("/addOrderProduct")
    public List<OrderProduct> addOrderProduct(@RequestBody List<OrderProduct> orderProducts) {
        System.out.println("Received Request Payload: " + orderProducts);
        return productOrderService.saveOrderProducts(orderProducts);
    }

    @GetMapping("/count-order")
    public long getUniqueInvoiceCount() {
        return productOrderService.countUniqueInvoiceNumbers();
    }

    @GetMapping("/distinctInvoiceNumbers/{userId}")
    public int getDistinctInvoiceNumbersByUserId(@PathVariable int userId) {
        return productOrderService.getDistinctInvoiceNumbersByUserId(userId);
    }

    @GetMapping("/distinctInvoiceNumbers")
    public List<String> findAllInvoiceNumber() {
        return productOrderService.countTotalInvoiceNumber();
    }

    @GetMapping("/invoice/{invoiceNumber}")
    public ResponseEntity<List<OrderProduct>> getOrderProductByInvoiceNumber(@PathVariable String invoiceNumber) {
        List<OrderProduct> orders = productOrderService.getOrderProductByInvoiceNumber(invoiceNumber);

        // Add your logic here based on the list of results

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/totalOrder")
    public List<Object[]> getTotalOrder() {
        return productOrderService.findTotalOrder();
    }

}
