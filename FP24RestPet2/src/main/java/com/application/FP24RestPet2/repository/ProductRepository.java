package com.application.FP24RestPet2.repository;

import com.application.FP24RestPet2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    void deleteById(int id);
}
