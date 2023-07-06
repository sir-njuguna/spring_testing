package com.example.spring_testing;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.spring_testing.person.controller.PersonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private PersonController personController;

    @Test
    public void contextLoadTest(){
        assertThat(personController).isNotNull();
    }

}
