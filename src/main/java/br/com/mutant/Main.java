package br.com.mutant;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
//		String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
		boolean result = main.isMutant(dna);
		System.out.println(result);
	}
	
	public boolean isMutant(String[] dna) {
		boolean toReturn = false;
		int size = dna.length;
		char[][] aux = new char[size][size];
		
		for(int i=0; i < size; i++) {
			for(int j=0; j< size; j++) {
				aux[i][j] = dna[i].charAt(j);
			}
		}
		char[] possibleLetters = {'T'};
		toReturn = checkLines(aux, possibleLetters, size);
		
		return toReturn;
	}

	private boolean checkLines(char[][] values, char[] possibleLetters, int size) {
		int count = 0;
		for(char letter : possibleLetters) {		
			
			char old = letter;
			for(int line=0; line<size; line++) {
				for(int column= 0; column < size; column++) {
					if(values[line][column] == letter && letter == old) {
						count++;
						System.out.println(letter+":  pos["+line+", "+column+"]");
					} 
					old = values[line][column];
					
				}
				if(count >= 4) {
					return true;
				}
				count = 0;
			}
		}
		return false;
	}
	
	
	
	
}
