package ru.daniil.springcourse.FirstRestApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
    @Table(name = "Person")
    public class Person {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "name")
        @NotEmpty(message = "name should be not null")
        @Size(min = 2, max = 30, message = "Name should be between 2 and 30 character")
        private String name;

        @Column(name = "age")
        @Min(value = 0, message = "Age should be greater then zero")
        private int age;

        @NotEmpty(message = "Name should be not empty")
        @Column(name = "email")
        private String email;

        @Column(name = "updated_who")
        private String updatedWho;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

        public Person() {}

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

    public String getUpdatedWho() {
        return updatedWho;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    public void setUpdatedWho(String updatedWho) {
        this.updatedWho = updatedWho;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

