package br.com.mutant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mutant.business.MutantBusiness;
import br.com.mutant.exceptions.NoMutantException;
import br.com.mutant.model.Dna;
import br.com.mutant.repository.MutantRepository;

@Service
public class MutantService {

	@Autowired
	private MutantBusiness mutantBusiness;
	
	@Autowired
	private MutantRepository mutantRepository;
	
	public boolean isMutant(Dna dna) {
		boolean isMutant = mutantBusiness.isMutant(dna.getDna());
		dna.setHumam(isMutant);
		mutantRepository.save(dna);
		if(!isMutant) {
			throw new NoMutantException(dna.toString());
		}
		return isMutant;
	}
	
	public List<Dna> findAll() {
		return mutantRepository.findAll();
	}
}
