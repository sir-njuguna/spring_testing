package com.example.spring_testing.person.controller;

import com.example.spring_testing.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {
    private PersonService personService;

    @GetMapping("name")
    public String getName(){
        return personService.getName();
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
