package com.marcosvcg.handsonhorizon.exceptions;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(ContaException.ContaNotFoundException.class)
    public ResponseEntity<Object> handleContaNotFoundException(ContaException.ContaNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ContaException.NumeroVazioException.class)
    public ResponseEntity<Object> handleNumeroVazioException(ContaException.NumeroVazioException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ContaException.DigitoInvalidoException.class)
    public ResponseEntity<Object> handleDigitoInvalidoException(ContaException.DigitoInvalidoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ContaException.SaldoInvalidoException.class)
    public ResponseEntity<Object> handleSaldoInvalidoException(ContaException.SaldoInvalidoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ContaException.TipoContaInvalidoException.class)
    public ResponseEntity<Object> handleTipoContaInvalidoException(ContaException.TipoContaInvalidoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(ContaException.TipoContaExistenteException.class)
    public ResponseEntity<Object> handleTipoContaExistenteException(ContaException.TipoContaExistenteException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(TransferenciaException.SaldoInsuficienteException.class)
    public ResponseEntity<Object> handleSaldoInsuficienteException(TransferenciaException.SaldoInsuficienteException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(TransferenciaException.ValorInvalidoException.class)
    public ResponseEntity<Object> handleValorInvalidoException(TransferenciaException.ValorInvalidoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(TransferenciaException.ContaInvalidaException.class)
    public ResponseEntity<Object> handleContaInvalidaException(TransferenciaException.ContaInvalidaException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(TransferenciaException.DataInvalidaException.class)
    public ResponseEntity<Object> handleDataInvalidaException(TransferenciaException.DataInvalidaException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        if (e.getCause() instanceof JsonMappingException jsonMappingException) {
            if (jsonMappingException.getOriginalMessage().contains("Cannot deserialize value of type `java.time.LocalDateTime`")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O formato da data e hora está inválido.");
            }
            if (jsonMappingException.getOriginalMessage().contains("not one of the values accepted for Enum class: [POUPANCA, CORRENTE]")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de conta inválido. Use os tipos CORRENTE ou POUPANCA.");
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao processar a solicitação.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }
}