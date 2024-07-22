package ru.daniil.app.service;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.daniil.app.models.Person;
import ru.daniil.app.repositories.PeopleRepository;
import ru.daniil.app.services.PeopleService;

@ExtendWith(MockitoExtension.class)
public class PeopleRepositoryTest {
    @InjectMocks
    private PeopleService peopleService;
    @Mock
    private PeopleRepository peopleRepository;

    @Test
    void findAll(){
        Person personForTest1 = new Person(32, "Gregor", "gregor@mail.com");
    }
}
