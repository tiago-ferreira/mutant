package br.com.mutant.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mutant.business.MutantBusiness;
import br.com.mutant.exceptions.NoMutantException;
import br.com.mutant.model.Dna;
import br.com.mutant.model.StatsResponse;
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
	
	public StatsResponse stats() {
		Long humam = mutantRepository.countByHumam(false);
		Long mutant = mutantRepository.countByHumam(true);
		BigDecimal ratio = new BigDecimal((double) mutant / humam).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return new StatsResponse(mutant, humam, ratio);
	}
}
