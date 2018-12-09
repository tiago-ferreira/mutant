package br.com.mutant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mutant.business.MutantBusiness;
import br.com.mutant.exceptions.NoMutantException;
import br.com.mutant.model.Dna;

@Service
public class MutantService {

	@Autowired
	private MutantBusiness mutantBusiness;
	
	public boolean isMutant(Dna dna) {
		boolean isMutant = mutantBusiness.isMutant(dna.getDna());
		if(!isMutant) {
			dna.setHumam(false);
			throw new NoMutantException(dna.toString());
		}
		return isMutant;
	}
}
