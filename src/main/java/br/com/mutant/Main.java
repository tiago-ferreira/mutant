package br.com.mutant;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
		String[] columns = main.getColumns(dna);
		
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
