package ru.daniil.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.daniil.app.models.Book;
import ru.daniil.app.models.Person;
import ru.daniil.app.repositories.BooksRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll(){
        return booksRepository.findAll();
    }

    public Book findOne(int id){
        Optional<Book> target = booksRepository.findById(id);
        return target.orElse(null);
    }

    public Book findByTitle(String title){
        return booksRepository.findByTitle(title);
    }

    public List<Book> findByOwnerId(int id){
        return booksRepository.findByOwnerId(id);
    }

    @Transactional
    public void save(Book bookToUpdate){
        booksRepository.save(bookToUpdate);
    }

    @Transactional
    public void update(int id, Book bookToUpdate){
        bookToUpdate.setId(id);
        booksRepository.save(bookToUpdate);
    }

    @Transactional
    public void delete(int id){
        booksRepository.deleteById(id);
    }

    @Transactional
    public void removeOwner(int bookId){
        Book book = booksRepository.findById(bookId).orElse(null);
        assert book != null;
        Person person = book.getOwner();
        person.getBookList().remove(book);
        book.setOwner(null);
    }
}
