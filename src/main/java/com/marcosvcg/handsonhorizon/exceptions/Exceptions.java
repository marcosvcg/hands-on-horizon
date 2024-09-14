package com.marcosvcg.handsonhorizon.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class Exceptions {

    public static class PessoaNotFoundException extends EntityNotFoundException {
        public PessoaNotFoundException() {
            super("Pessoa não encontrada.");
        }
    }
}
