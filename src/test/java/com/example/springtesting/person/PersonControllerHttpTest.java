package com.example.springtesting.person;

import com.example.springtesting.person.controller.PersonController;
import com.example.springtesting.person.form.CreatePerson;
import com.example.springtesting.person.model.Person;
import com.example.springtesting.person.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.hamcrest.core.StringContains.containsStringIgnoringCase;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(PersonController.class)
public class PersonControllerHttpTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;


    @Test
    public void testNameEndpoint() throws Exception {
        String url = "/person/name";
        String expectedName = "John";

        when(personService.getName()).thenReturn(expectedName);

        this.mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsStringIgnoringCase(expectedName)));
    }


    @Test
    public void testThatAPersonCanBeRegistered() throws Exception{
        String url = "/person/register";

        Person person = new Person();
        person.setId(1L);
        person.setName("John");
        person.setDateOfBirth(new Date());

        when(personService.registerPerson(any(CreatePerson.class))).thenReturn(person);

        CreatePerson form = new CreatePerson();
        form.setName("John");
        form.setDateOfBirth(new Date());

        String payload = objectMapper.writeValueAsString(form);
        System.out.println(payload);
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON).
                        content(payload)
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("John"));
    }
}
