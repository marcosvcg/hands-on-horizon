package com.marcosvcg.handsonhorizon.exceptions;

public class TransferenciaException {

    public static class SaldoInsuficienteException extends IllegalArgumentException {
        public SaldoInsuficienteException() {
            super("Saldo insuficiente para realizar a transferência.");
        }
    }

    public static class ValorInvalidoException extends IllegalArgumentException {
        public ValorInvalidoException() {
            super("O valor da operação não pode ser negativo ou nulo.");
        }
    }

    public static class ContaInvalidaException extends IllegalArgumentException {
        public ContaInvalidaException() {
            super("Conta inválida.");
        }
    }

    public static class DataInvalidaException extends IllegalArgumentException {
        public DataInvalidaException() {
            super("O formato da data está inválido.");
        }
    }
}
