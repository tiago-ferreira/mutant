package br.com.mutant.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "dna")
public class Dna {

	private String[] dna;
	private Boolean humam;
	
	

}
