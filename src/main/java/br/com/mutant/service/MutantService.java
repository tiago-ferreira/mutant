package br.com.mutant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mutant.business.MutantBusiness;
import br.com.mutant.model.Dna;

@Service
public class MutantService {

	@Autowired
	private MutantBusiness mutantBusiness;
	
	public boolean isMutant(Dna dna) {
		return mutantBusiness.isMutant(dna.getDna());
	}
}
