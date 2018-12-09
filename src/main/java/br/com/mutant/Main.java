package br.com.mutant;

public class Main {

	public static void main(String[] args) {
		Mutant mutant = new Mutant();
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		mutant.isMutant(dna);
	}
	
}