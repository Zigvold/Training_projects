package com.application.manager.services;

import com.application.manager.models.Product;
import com.application.manager.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void save(Product product){
        productRepository.save(product);
    }

    public void delete(int id){
        productRepository.deleteById(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(int id){
        return productRepository.findById(id);
    }

    public void update(Product updatedProduct){
        productRepository.save(updatedProduct);
    }
}
