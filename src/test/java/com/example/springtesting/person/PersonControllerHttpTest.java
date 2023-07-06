package com.example.spring_testing.person;

import com.example.spring_testing.person.controller.PersonController;
import com.example.spring_testing.person.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsStringIgnoringCase;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PersonController.class)
public class PersonControllerHttpTest {

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
}
