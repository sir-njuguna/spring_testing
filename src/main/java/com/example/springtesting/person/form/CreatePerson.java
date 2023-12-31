package com.example.springtesting.person.form;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class CreatePerson {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Date dateOfBirth;
}
