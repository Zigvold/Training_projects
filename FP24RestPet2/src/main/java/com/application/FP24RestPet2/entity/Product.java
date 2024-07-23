package com.application.FP24RestPet2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    public Product(String title, String details) {
        this.title = title;
        this.details = details;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "details")
    private String details;
}
