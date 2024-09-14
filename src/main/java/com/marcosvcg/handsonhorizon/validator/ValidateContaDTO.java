package com.marcosvcg.handsonhorizon.validator;

import com.marcosvcg.handsonhorizon.exceptions.ContaException;
import com.marcosvcg.handsonhorizon.model.dto.ContaDTO;

import java.math.BigDecimal;

public class ValidateContaDTO {

    public static boolean isNumeroEmpty(ContaDTO dto) {
        return dto.numero().isEmpty();
    }

    public static boolean isDigitoInvalid(ContaDTO dto) {
        return dto.digito() < 0 || dto.digito() > 9;
    }

    public static boolean isSaldoInvalid(ContaDTO dto) {
        return dto.saldo() == null || dto.saldo().compareTo(BigDecimal.ZERO) < 0;
    }

    public void validateContaDTO(ContaDTO dto) {
        if (isNumeroEmpty(dto)) throw new ContaException.NumeroVazioException();
        if (isDigitoInvalid(dto)) throw new ContaException.DigitoInvalidoException();
        if (isSaldoInvalid(dto)) throw new ContaException.SaldoInvalidoException();
    }
}
