package com.example.spring_testing.person.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Person {

    @Id
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Date dateOfBirth;
}
