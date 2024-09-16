package com.marcosvcg.handsonhorizon.util;

import com.marcosvcg.handsonhorizon.exceptions.TransferenciaException;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class ValidationHelper {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofPattern("dd/MM/uuuu HH:mm:ss", new Locale("pt", "BR"))
            .withResolverStyle(ResolverStyle.STRICT);

    public static boolean isTelefoneValid(String telefone) {
        return telefone.length() == 11 && telefone.matches("\\d{11}");
    }

    public static boolean isCpfValid(String cpf) {
        return cpf.length() == 11 && cpf.matches("\\d{11}");
    }

    public static boolean isDataValid(String data) {
        try {
            FORMATTER.parse(data);
            return true;
        } catch (DateTimeParseException e) {
            throw new TransferenciaException.DataInvalidaException();
        }
    }
}
