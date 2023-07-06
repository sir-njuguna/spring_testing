package com.example.springtesting.person.view;

import com.example.springtesting.person.model.Person;

import java.util.Date;

public class PersonView {
    private final Person entity;
    public PersonView(Person entity){
        this.entity = entity;
    }

    public String getName(){
        return entity.getName();
    }

    public Date getDateOfBirth(){
        return entity.getDateOfBirth();
    }
}
