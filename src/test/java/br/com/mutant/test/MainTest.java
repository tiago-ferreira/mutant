//package br.com.mutant.test;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import br.com.mutant.Main;
//
//public class MainTest {
//
//	Main main = new Main();
//	
//	
//	@Test
//	public void testMutant() {
//		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
//		boolean result = main.isMutant(dna);
//		Assertions.assertTrue(result);
//	}	
//	
//	@Test
//	public void testNonMutant() {
//		String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
//		boolean result = main.isMutant(dna);
//		Assertions.assertFalse(result);
//	}	
//	
//	
//	@Test
//	public void testByColumnMutant() {
//		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
//		boolean result = main.isMutant(dna);
//		Assertions.assertTrue(result);
//	}	
//	
//}
