package com.marcosvcg.handsonhorizon.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class ContaException {

    public static class ContaNotFoundException extends EntityNotFoundException {
        public ContaNotFoundException() {
            super("Conta bancária não encontrada.");
        }
    }

    public static class NumeroVazioException extends IllegalArgumentException {
        public NumeroVazioException() {
            super("O número da conta não pode estar vazio.");
        }
    }

    public static class DigitoInvalidoException extends IllegalArgumentException {
        public DigitoInvalidoException() {
            super("O dígito da conta é inválido.");
        }
    }

    public static class SaldoInvalidoException extends IllegalArgumentException {
        public SaldoInvalidoException() {
            super("O saldo da conta não pode ser negativo.");
        }
    }

    public static class TipoContaExistenteException extends IllegalArgumentException {
        public TipoContaExistenteException() {
            super("O cliente já possui uma conta com esse tipo.");
        }
    }
}
