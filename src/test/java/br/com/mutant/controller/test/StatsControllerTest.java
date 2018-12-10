package br.com.mutant.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StatsControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	HttpHeaders headers = new HttpHeaders();

	@Test
	@Disabled
	void testStats() {
		String response = restTemplate.getForObject("/stats", String.class);
		System.out.println(response);
		Assertions.assertTrue(response.contains("count_mutant_dna"));
		Assertions.assertTrue(response.contains("count_human_dna"));
		Assertions.assertTrue(response.contains("ratio"));
	}

}
