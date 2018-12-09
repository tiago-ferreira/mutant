package br.com.mutant;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
//		String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
//		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCATA","TCACTG"};
//		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
//		String oblique = main.getOblique(dna);
//		System.out.println(oblique);
		String[] dna = {"ATGCGA","CAGTCC","TTATGT","AGAAGG","CCCATA","TCACTG"};
		int size = dna.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(dna[i].charAt(j));
				
			}
			System.out.println();
		}
//		String[] columns = main.getColumns(dna);
		
	}
	
	private String getOblique(String[] dna) {
		int size = dna.length;
		String oblique = "";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(i == j) {
					oblique += dna[i].charAt(j);					
				}
				
			}
		}

		return oblique;
	}

	private String[] getColumns(String[] dna) {
		int size = dna.length;
		String aux = "";
		String[] toReturn = new String[size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				aux += dna[j].charAt(i);
				
			}
			toReturn[i] = aux;
			aux = "";
		}

		return toReturn;
	}

}
