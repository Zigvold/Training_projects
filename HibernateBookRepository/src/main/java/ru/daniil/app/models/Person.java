package ru.daniil.app.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "People")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(value = 10, message = "Age must be upper then 10")
    @Max(value = 110, message = "Age must be lower then 110")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Field name must not be blank")
    @Size(max = 200, message = "This field must contain lower then 200 symbols")
    @Column(name = "name")
    private String name;

    @Email(message = "Not correct email")
    @NotEmpty(message = "Field email must not be empty")
    @Size(min = 5, max = 100, message = "Size of this field must be upper then 5 and lower then 100 symbols")
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "owner")
    List<Book> bookList;

    public Person() {}

    public Person(int age, String name, String email) {
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public Person(int age, String name, String email, List<Book> bookList) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bookList=" + bookList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(name, person.name) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, email);
    }
}
