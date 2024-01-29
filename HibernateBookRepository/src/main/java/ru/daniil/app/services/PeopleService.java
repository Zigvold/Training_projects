package ru.daniil.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.daniil.app.models.Book;
import ru.daniil.app.models.Person;
import ru.daniil.app.repositories.BooksRepository;
import ru.daniil.app.repositories.PeopleRepository;

import javax.swing.plaf.PanelUI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService{
    private final PeopleRepository peopleRepository;
    private final BooksRepository booksRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository, BooksRepository booksRepository) {
        this.peopleRepository = peopleRepository;
        this.booksRepository = booksRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findOne(int id){
        Optional<Person> optionalPerson = peopleRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    public List<Person> findByEmail(String email){
        return peopleRepository.findByEmail(email);
    }

    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }

    @Transactional
    public void update(Person updatedPerson, int id){
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }

    @Transactional
    public void assignBook(int personId, int bookId){
        Person person = peopleRepository.findById(personId).orElse(null);
        Book book = booksRepository.findById(bookId).orElse(null);

        assert person != null;
        if (person.getBookList() == null) person.setBookList(Collections.singletonList(book));
        else person.getBookList().add(book);

        assert book != null;
        book.setOwner(person);
    }
}
