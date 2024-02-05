package ru.daniil.springcourse.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.daniil.springcourse.FirstSecurityApp.models.Person;
import ru.daniil.springcourse.FirstSecurityApp.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> findByUserName(String name){
        return peopleRepository.findByUsername(name);
    }
}
