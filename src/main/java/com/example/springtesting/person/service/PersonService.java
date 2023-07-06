package com.example.springtesting.person.service;

import com.example.springtesting.person.form.CreatePerson;
import com.example.springtesting.person.model.Person;
import com.example.springtesting.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public String getName(){
        return "John";
    }

    public Person registerPerson(CreatePerson form){
        Person person = new Person();
        person.setName(form.getName());
        person.setDateOfBirth(form.getDateOfBirth());

        return personRepository.save(person);
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
