package com.example.spring_testing.person;


import com.example.spring_testing.person.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Test
    public void testThatGetNameReturnsDefault(){
        String expectedName = "John";
        String result = personService.getName();

        assertThat(result).containsIgnoringCase(expectedName);
    }
}
