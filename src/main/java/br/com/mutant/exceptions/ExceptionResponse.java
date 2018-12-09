package br.com.mutant.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {

    private LocalDateTime dateTim;
    private String message;
    private String details;
}
