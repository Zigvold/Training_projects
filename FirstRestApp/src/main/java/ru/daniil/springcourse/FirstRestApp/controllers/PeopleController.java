package ru.daniil.springcourse.FirstRestApp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.daniil.springcourse.FirstRestApp.dto.PersonDTO;
import ru.daniil.springcourse.FirstRestApp.models.Person;
import ru.daniil.springcourse.FirstRestApp.services.PeopleService;
import ru.daniil.springcourse.FirstRestApp.util.PersonErrorResponse;
import ru.daniil.springcourse.FirstRestApp.util.PersonNotCreatedException;
import ru.daniil.springcourse.FirstRestApp.util.PersonNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/people/api")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/index")
    public List<PersonDTO> index(){
        return peopleService.findAll().stream()
                .map(this::convertToPersonDTO)
                .collect(Collectors.toList());
                //Jackson конвертирует объекты в json
    }

    @GetMapping("/{id}")
    public PersonDTO show(@PathVariable("id") int id){
        return convertToPersonDTO(peopleService.findByID(id)); //Jackson конвертирует аобъекты в json
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid PersonDTO personDTO,
                                             BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errors = new StringBuilder();
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error: errorList) {
                errors.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append(";");
            }
            throw new PersonNotCreatedException(errors.toString());
        }
        // Отправляем Http ответ с пустым телом и со статусом OK
        peopleService.save(convertToPerson(personDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e){
        PersonErrorResponse response = new PersonErrorResponse(
                "Person not found", System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotCreatedException e){
        PersonErrorResponse response = new PersonErrorResponse(
                e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Person convertToPerson(PersonDTO personDTO){
        Person person = new Person();

        person.setName(personDTO.getName());
        person.setAge(personDTO.getAge());
        person.setEmail(personDTO.getEmail());

        return person;
    }

    private PersonDTO convertToPersonDTO(Person person){
        PersonDTO personDTO = new PersonDTO();

        personDTO.setAge(person.getAge());
        personDTO.setEmail(person.getEmail());
        personDTO.setName(person.getName());

        return personDTO;
    }
}
