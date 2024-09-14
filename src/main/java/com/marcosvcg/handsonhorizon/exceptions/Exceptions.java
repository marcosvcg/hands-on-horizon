package com.marcosvcg.handsonhorizon.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class Exceptions {

    public static class PessoaNotFoundException extends EntityNotFoundException {
        public PessoaNotFoundException() {
            super("Pessoa não encontrada.");
        }
    }

    public static class NomeVazioException extends IllegalArgumentException {
        public NomeVazioException() {
            super("O nome não pode estar vazio.");
        }
    }

    public static class TelefoneVazioException extends IllegalArgumentException {
        public TelefoneVazioException() {
            super("O telefone não pode estar vazio.");
        }
    }

    public static class CpfVazioException extends IllegalArgumentException {
        public CpfVazioException() {
            super("O cpf não pode estar vazio.");
        }
    }
}
