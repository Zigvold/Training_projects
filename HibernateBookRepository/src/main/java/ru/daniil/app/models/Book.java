package ru.daniil.app.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(value = 1900, message = "Year of production must be upper then 1900")
    @Max(value = 2045, message = "Year of production must be lower then 2045")
    @Column(name = "year_of_production")
    private int yearOfProduction;

    @NotEmpty(message = "The movie title must not be empty")
    @Size(min = 5, max = 200, message = "The movie title must contain upper then 5 or lower then 200 symbols")
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Book() {}


    public Book(int yearOfProduction, String title) {
        this.yearOfProduction = yearOfProduction;
        this.title = title;
    }

    public Book(int yearOfProduction, String title, Person owner) {
        this.yearOfProduction = yearOfProduction;
        this.title = title;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", yearOfProduction=" + yearOfProduction +
                ", title='" + title + '\'' +
                ", owner=" + owner +
                '}';
    }
}
