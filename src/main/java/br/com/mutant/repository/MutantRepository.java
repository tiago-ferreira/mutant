package br.com.mutant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mutant.model.Dna;

public interface MutantRepository extends MongoRepository<Dna, String[]>{
	
	Long countByHumam(boolean value);

}
