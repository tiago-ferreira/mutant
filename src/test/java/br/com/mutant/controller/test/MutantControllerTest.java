package br.com.mutant.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.mutant.model.Dna;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MutantControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	HttpHeaders headers = new HttpHeaders();

	@Test
	void testMutant() {
		String[] dnaValue = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		Dna dna = new Dna();
		dna.setDna(dnaValue);
		HttpEntity<Dna> entity = new HttpEntity<Dna>(dna, headers);
		ResponseEntity<String> response = restTemplate.exchange("/mutant", HttpMethod.POST, entity, String.class);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testNoMutant() {
		String[] dnaValue = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
		Dna dna = new Dna();
		dna.setDna(dnaValue);
		HttpEntity<Dna> entity = new HttpEntity<Dna>(dna, headers);
		ResponseEntity<String> response = restTemplate.exchange("/mutant", HttpMethod.POST, entity, String.class);
		Assertions.assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
	}
	
	
	@Test
	void testInvalidDna() {
		String[] dnaValue = {"ATGCGA","CATGC","TTT","AGAG","GCGCA","TCACTG"};
		Dna dna = new Dna();
		dna.setDna(dnaValue);
		HttpEntity<Dna> entity = new HttpEntity<Dna>(dna, headers);
		ResponseEntity<String> response = restTemplate.exchange("/mutant", HttpMethod.POST, entity, String.class);
		Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}

}
