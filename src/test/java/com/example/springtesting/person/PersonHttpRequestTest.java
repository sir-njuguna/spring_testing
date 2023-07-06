package com.example.springtesting.person;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonHttpRequestTest {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testThatNameEndpointReturnsName(){
        String url = String.format("http://localhost:%d/person/name", port);
        String response = restTemplate.getForObject(url, String.class);
        assertThat(response).containsIgnoringCase("John");
    }
}
