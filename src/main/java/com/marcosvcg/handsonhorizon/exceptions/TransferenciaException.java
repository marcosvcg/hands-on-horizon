package com.marcosvcg.handsonhorizon.exceptions;

public class TransferenciaException {

    public static class SaldoInsuficienteException extends IllegalArgumentException {
        public SaldoInsuficienteException() {
            super("Saldo insuficiente para realizar a transferência.");
        }
    }

    public static class ValorInvalidoException extends IllegalArgumentException {
        public ValorInvalidoException() {
            super("O valor da operação não pode ser negativo.");
        }
    }

    public static class ContaInvalidaException extends IllegalArgumentException {
        public ContaInvalidaException() {
            super("Conta inválida.");
        }
    }
}
