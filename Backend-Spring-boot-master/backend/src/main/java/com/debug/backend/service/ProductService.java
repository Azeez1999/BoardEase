package com.debug.backend.service;

import com.debug.backend.entity.OrderProduct;
import com.debug.backend.entity.Product;
import com.debug.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String productName) {
        return repository.findByProductName(productName);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public String updateProduct(int id, Product updatedProduct) {
        if (repository.existsById(id)) {
            Product existProduct = repository.findById(id).get();
            existProduct.setProductName(updatedProduct.getProductName());
            existProduct.setDescription(updatedProduct.getDescription());
            existProduct.setSellingPrice(updatedProduct.getSellingPrice());
            existProduct.setPurchasePrice(updatedProduct.getPurchasePrice());
            repository.save(existProduct);
            return "Product Details updated";
        } else {
            return "Product with ID " + id + " does not exist";
        }
    }


    public long countTotalProducts() {
        return repository.count();
    }

}
