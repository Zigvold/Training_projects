package ru.daniil.springcourse.FirstRestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.daniil.springcourse.FirstRestApp.models.Person;
import ru.daniil.springcourse.FirstRestApp.repositories.PeopleRepository;
import ru.daniil.springcourse.FirstRestApp.util.PersonNotFoundException;

import java.util.List;

@Service
@Transactional
public class PeopleService {

    private final PeopleRepository peopleRepository;


    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findByID(int id){
        return peopleRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }

}
