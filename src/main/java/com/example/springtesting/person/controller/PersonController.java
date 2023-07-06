package com.example.springtesting.person.controller;

import com.example.springtesting.person.form.CreatePerson;
import com.example.springtesting.person.model.Person;
import com.example.springtesting.person.service.PersonService;
import com.example.springtesting.person.view.PersonView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController {
    private PersonService personService;

    @GetMapping("name")
    public String getName(){
        return personService.getName();
    }

    @PostMapping("register")
    public ResponseEntity<PersonView> registerPerson(@RequestBody @Valid CreatePerson form){
        Person person = personService.registerPerson(form);
        return new ResponseEntity<>( new PersonView(person), HttpStatus.OK);
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
