package com.example.resttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest
class ResttemplateApplicationTests {

	@Test
	void cosumerAPI() {

		RestTemplate template = new RestTemplate();
		//https://reqres.in/api/users?page=2
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("reqres.in")
				.path("/api/users/2")
				//.queryParam("page", "2")
				.build();


			ResponseEntity<String> entity = template.getForEntity(uri.toUriString(),String.class);

			System.out.println(entity.getBody().getClass().getName() );


	}

}
