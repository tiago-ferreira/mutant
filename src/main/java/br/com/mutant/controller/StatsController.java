package br.com.mutant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mutant.model.StatsResponse;
import br.com.mutant.service.MutantService;

@RestController
@RequestMapping("/stats")
public class StatsController {
	
	@Autowired
	private MutantService mutantService;
	
	
	@GetMapping
	public StatsResponse stats() {
		return mutantService.stats();
	}

}
