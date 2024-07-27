package com.application.manager.client;

import com.application.manager.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRestClient {

    List<Product> findAll();

    Product createProduct(String title, String details);

    Optional<Product> findProduct(int productId);

    void deleteProduct(int productId);

    void updateProduct(int productId, String title, String details);
}
