package br.com.mutant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mutant.model.Dna;
import br.com.mutant.service.MutantService;

@RestController
@RequestMapping("/mutant")
public class MutantController {

	
	@Autowired
	private MutantService mutantService;
	
	@PostMapping
	public boolean isMutant(@RequestBody Dna dna) {
		return mutantService.isMutant(dna);
	}

}