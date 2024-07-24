package com.application.FP24RestPet2.service;

import com.application.FP24RestPet2.controller.payload.NewProductPayload;
import com.application.FP24RestPet2.controller.payload.UpdateProductPayload;
import com.application.FP24RestPet2.entity.Product;
import com.application.FP24RestPet2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product save(Product product){
        return productRepository.save(product);
    }

    @Transactional
    public Product save(NewProductPayload payload){
        return productRepository.save(new Product(payload.title(), payload.details()));
    }

    @Transactional
    public void delete(int id){
        productRepository.deleteById(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(int id){
        return productRepository.findById(id);
    }

    @Transactional
    public void update(Product updatedProduct){
        productRepository.save(updatedProduct);
    }

    @Transactional
    public void update(int id, UpdateProductPayload payload){
        productRepository.save(new Product(id, payload.title(), payload.details()));
    }


    @Transactional
    public Product createProduct(NewProductPayload newProductPayload){
        return new Product(newProductPayload.title(), newProductPayload.details());
    }
}
