package br.com.mutant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatsResponse {

	
	@JsonProperty(value="count_mutant_dna")
	private Long countMutantDna;
	@JsonProperty(value="count_human_dna")
	private Long countHumamDna;
	private Double ratio;
}
