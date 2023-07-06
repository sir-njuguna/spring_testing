package com.example.spring_testing.person.repository;

import com.example.spring_testing.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Long, Person> {
}
