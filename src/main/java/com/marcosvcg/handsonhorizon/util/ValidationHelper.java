package com.marcosvcg.handsonhorizon.util;

import com.marcosvcg.handsonhorizon.exceptions.TransferenciaException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidationHelper {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static boolean isTelefoneValid(String telefone) {
        return telefone.length() == 11 && telefone.matches("\\d{11}");
    }

    public static boolean isCpfValid(String cpf) {
        return cpf.length() == 11 && cpf.matches("\\d{11}");
    }

    public static boolean isDataValid(String data) {
        try {
            LocalDateTime.parse(data, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            throw new TransferenciaException.DataInvalidaException();
        }
    }
}
