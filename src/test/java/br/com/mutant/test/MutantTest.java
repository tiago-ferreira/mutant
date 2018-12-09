package br.com.mutant.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.mutant.Mutant;

class MutantTest {

	Mutant main = new Mutant();
	
	
	@Test
	public void testMutant() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		boolean result = main.isMutant(dna);
		Assertions.assertTrue(result);
	}	
	
	@Test
	public void testNonMutant() {
		String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
		boolean result = main.isMutant(dna);
		Assertions.assertFalse(result);
	}	
	
	
	@Test
	public void testMutantByLine() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCATA","TCACTG"};
		boolean result = main.isMutant(dna);
		Assertions.assertFalse(result);
	}	
	
	@Test
	public void testMutantByColumn() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","GAAAAG","CCCCTA","TCACTG"};
		boolean result = main.isMutant(dna);
		Assertions.assertTrue(result);
	}	
	
	@Test
	public void testMutantByObliquely() {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		boolean result = main.isMutant(dna);
		Assertions.assertTrue(result);
	}	
	
}
