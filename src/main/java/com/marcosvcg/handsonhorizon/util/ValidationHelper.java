package com.marcosvcg.handsonhorizon.util;

public class ValidationHelper {

    public static boolean isTelefoneValid(String telefone) {
        return telefone.length() == 11 && telefone.matches("\\d{11}");
    }

    public static boolean isCpfValid(String cpf) {
        return cpf.length() == 11 && cpf.matches("\\d{11}");
    }
}
