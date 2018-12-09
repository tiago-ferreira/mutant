package br.com.mutant.business;

import org.springframework.stereotype.Component;

@Component
public class MutantBusiness {

	public boolean isMutant(String[] dna) {
		char[] possibleLetters = {'A','C','G', 'T' };
		boolean value = checkStrings(dna, possibleLetters);
		if(value) {
			return true;
		}
		String[] columns = getColumns(dna);
		value = checkStrings(columns, possibleLetters);
		if(value) {
			return true;
		}
		String oblique = getOblique(dna);
		value = checkString(oblique, possibleLetters);
		if(value) {
			return true;
		}
		String[] dnaReverse = reverseStrings(dna);
		oblique = getOblique(dnaReverse);
		value = checkString(oblique, possibleLetters);
		if(value) {
			return true;
		}
		return false;
	}

	private boolean checkStrings(String[] dna, char[] possibleLetters) {
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
	
	private boolean checkString(String line, char[] possibleLetters) {
		for(char letter : possibleLetters) {			
				boolean value = checkLine(line, letter);
				if(value) {
					return true;
				}
		}
		return false;
	}
	
	private String[] reverseStrings(String[] dna) {
		int size = dna.length;
		String[] toReturn = new String[size];
		for (int i=0; i<size; i++) {
			toReturn[i] = new StringBuilder(dna[i]).reverse().toString();
		}
		return toReturn;
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
				if(count == 3) { // case check occurrence in initial sequence return  
					return 3;
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
