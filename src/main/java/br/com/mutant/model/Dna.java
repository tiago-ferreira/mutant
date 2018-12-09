package br.com.mutant.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "dna")
@ApiModel(description = "All Details about Dna")
public class Dna {

	@ApiModelProperty(notes = "All data about dna")
	private String[] dna;
	@ApiModelProperty(notes = "Flag to identifier if is a humam or mutant")
	private Boolean humam;
	
	

}
