package com.example.spring_testing.person.service;

import com.example.spring_testing.person.form.CreatePerson;
import com.example.spring_testing.person.model.Person;
import com.example.spring_testing.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public String getName(){
        return "John";
    }

    private void createPerson(CreatePerson form){
        Person person = new Person();
        person.setName(form.getName());
        person.setDateOfBirth(form.getDateOfBirth());
        personRepository.save(person)
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
