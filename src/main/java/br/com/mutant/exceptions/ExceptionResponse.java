package br.com.mutant.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionResponse {

    private LocalDateTime dateTim;
    private String message;
    private String details;
}
