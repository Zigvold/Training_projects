package ru.flamehander.spring.securityjwt.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Integer;

    @Column(name = "name")
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }
}
