package com.example.resttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ResttemplatePostTests {

    @Test
    void cosumerAPIpost() {

        RestTemplate template = new RestTemplate();
        //https://reqres.in/api/login
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("reqres.in")
                .path("/api/login")
                //.queryParam("page", "2")
                .build();

        Map<String, String> map = new HashMap<>();
        map.put("email", "eve.holt@reqres.in");
        map.put("password", "cityslicka");
        // send POST request
        ResponseEntity<Map> response = template.postForEntity(uri.toUriString(), map, Map.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response.getBody().get("token"));
        } else {
            System.out.println("Request Failed");

        }
    }
}