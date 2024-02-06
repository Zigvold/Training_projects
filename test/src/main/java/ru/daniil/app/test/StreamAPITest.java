package ru.daniil.app.test;

import ru.daniil.app.models.Person;

import java.util.ArrayList;
import java.util.List;

public class StreamAPITest {
    private StreamAPITest(){}

    private static List<Person> people = new ArrayList<>()
    {{
        for (int i = 0; i < 10; i++) {
            add(new Person(FakerTest.generateRandomFirstName(),
                           FakerTest.generateRandomLastName(),
                           FakerTest.generateRandomAge()));
        }
    }};

    public static List<Person> getPeopleList(){
        return people;
    }
}
