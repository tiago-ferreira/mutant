package br.com.mutant.model;

import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection="dna")
public class Dna {

	@ApiModelProperty(notes = "All data about dna")
	private String[] dna;
	@ApiModelProperty(notes = "Flag to identifier if is a humam or mutant")
	private Boolean humam;
	
	

}
