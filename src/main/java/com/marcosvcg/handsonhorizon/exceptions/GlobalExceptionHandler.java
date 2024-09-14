package com.marcosvcg.handsonhorizon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PessoaException.PessoaNotFoundException.class)
    public ResponseEntity<Object> handlePessoaNotFoundException(PessoaException.PessoaNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(PessoaException.NomeVazioException.class)
    public ResponseEntity<Object> handleNomeVazioException(PessoaException.NomeVazioException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(PessoaException.TelefoneVazioException.class)
    public ResponseEntity<Object> handleTelefoneVazioException(PessoaException.TelefoneVazioException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(PessoaException.CpfVazioException.class)
    public ResponseEntity<Object> handleCpfVazioException(PessoaException.CpfVazioException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(PessoaException.TelefoneInvalidoException.class)
    public ResponseEntity<Object> handleTelefoneInvalidoException(PessoaException.TelefoneInvalidoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(PessoaException.CpfInvalidoException.class)
    public ResponseEntity<Object> handleCpfInvalidoException(PessoaException.CpfInvalidoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(PessoaException.CpfRegistradoException.class)
    public ResponseEntity<Object> handleCpfRegistradoException(PessoaException.CpfRegistradoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }
}