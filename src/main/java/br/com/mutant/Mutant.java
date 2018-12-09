package br.com.mutant;

public class Mutant {

	public static void main(String[] args) {
		Mutant main = new Mutant();
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
//		String[] dna = {"ATGCGA","CAGTGC","TTATTT","AGACGG","GCGTCA","TCACTG"};
		boolean result = main.isMutant(dna);
		System.out.println(result);
	}
	
	public boolean isMutant(String[] dna) {
		char[] possibleLetters = {'A','C','G', 'T' };
		boolean value = checkString(dna, possibleLetters);
		if(value) {
			return true;
		}
		String[] columns = getColumns(dna);
		value = checkString(columns, possibleLetters);
		if(value) {
			return true;
		}
		return false;
	}

	private boolean checkString(String[] dna, char[] possibleLetters) {
		for(char letter : possibleLetters) {			
			for(String line : dna) {
				boolean value = checkLine(line, letter);
				if(value) {
					return true;
				}
			}
		}
		return false;
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

	private boolean checkLine(String dna, char letter) {
		int positionsOfOccurrenceCharacter[] = getPositionOcurrence(dna, letter);
		int count = countOccurrenceInSequence(positionsOfOccurrenceCharacter);
		if(count >= 3) {
			return true;
		}
		return false;
	}

	private int[] getPositionOcurrence(String dna, char letter) {
		int qtdOccurrence = countOccurrences(dna, letter);
		int positionsOfOccurrenceCharacter[] = new int[qtdOccurrence];
		for(int i=0, j=0; i<dna.length(); i++) {			
			if(dna.charAt(i) == letter) {
				positionsOfOccurrenceCharacter[j] = i;
				j++;
			}
		}
		return positionsOfOccurrenceCharacter;
	}

	private int countOccurrenceInSequence(int[] pos) {
		int count = 0;
		for(int i=0; i < pos.length -1; i++) {
			if( (pos[i] + 1) == pos[i+1]) {
				count++;
				if(count == 4) { // case check occurrence in initial sequence return  
					return 4;
				}
			} else {
				count = 0;
			}
		}
		return count;
	}

	//count occurrence characteres on string
	private int countOccurrences(String someString, char someChar) {
		int count =0;
		for (int i = 0; i < someString.length(); i++) {
			if (someString.charAt(i) == someChar) {
				count++;
			}
		}
		return count;
	}


}
