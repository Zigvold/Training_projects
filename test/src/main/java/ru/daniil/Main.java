package ru.daniil;

import ru.daniil.app.models.Person;
import ru.daniil.app.test.FakerTest;
import ru.daniil.app.test.StreamAPITest;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //FakerTest.printSomeFakeData();
        System.out.println("\n"+"До потока :"+"\n");
        for (int i = 0; i < StreamAPITest.getPeopleList().size(); i++) {
            System.out.println(StreamAPITest.getPeopleList().get(i));
        }

        System.out.println("\n"+"После потока :" + "\n");
        List<Person> person2 = StreamAPITest.getPeopleList().stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getFirstName))
                .map(p -> new Person(p.getFirstName(), p.getLastName(), p.getAge()+30))
                .toList();
        person2.forEach(System.out::println);
    }
}