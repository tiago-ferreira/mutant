package br.com.mutant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@EqualsAndHashCode(callSuper = false)
public class NoMutantException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String dna;

	public NoMutantException(String dna) {
		super(String.format("No Mutant : %s ", dna));
		this.dna = dna;
	}

}
