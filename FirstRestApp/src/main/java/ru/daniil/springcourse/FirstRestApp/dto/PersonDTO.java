package ru.daniil.springcourse.FirstRestApp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PersonDTO {

    @NotEmpty(message = "name should be not null")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 character")
    private String name;

    @Min(value = 0, message = "Age should be greater then zero")
    private int age;

    @NotEmpty(message = "Name should be not empty")
    private String email;

    public PersonDTO(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public PersonDTO() {}

    public String getName() {
        return name;
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
}
