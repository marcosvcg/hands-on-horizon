package com.marcosvcg.handsonhorizon.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PessoaException {

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

    public static class NomeInvalidoException extends IllegalArgumentException {
        public NomeInvalidoException() {
            super("Nome inválido.");
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

    public static class TelefoneInvalidoException extends SecurityException {
        public TelefoneInvalidoException() {
            super("O telefone precisa conter apenas 11 dígitos numéricos.");
        }
    }

    public static class CpfInvalidoException extends SecurityException {
        public CpfInvalidoException() {
            super("O cpf precisa conter apenas 11 dígitos numéricos.");
        }
    }

    public static class CpfRegistradoException extends SecurityException {
        public CpfRegistradoException() {
            super("Esse cpf já está registrado em nossa base de dados.");
        }
    }
}
