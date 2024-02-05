package ru.daniil.springcourse.FirstSecurityApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.daniil.springcourse.FirstSecurityApp.models.Person;
import ru.daniil.springcourse.FirstSecurityApp.services.PeopleService;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (peopleService.findByUserName(person.getUsername()).isPresent()){
            errors.rejectValue("username","",
                    "Человек с таким именем пользователя уже существует");
        }
    }
}
