package com.marcosvcg.handsonhorizon.validator;

import com.marcosvcg.handsonhorizon.exceptions.ContaException;
import com.marcosvcg.handsonhorizon.model.dto.ContaDTO;
import com.marcosvcg.handsonhorizon.util.TipoContaEnum;

import java.math.BigDecimal;

public class ValidateContaDTO {

    public static boolean isValorInvalid(BigDecimal valor) {
        return valor == null || valor.compareTo(BigDecimal.ZERO) <= 0;
    }

    public static boolean isNumeroEmpty(ContaDTO dto) {
        return dto.numero().isEmpty();
    }

    public static boolean isDigitoInvalid(ContaDTO dto) {
        return dto.digito() < 0 || dto.digito() > 9;
    }

    public static boolean isSaldoInvalid(ContaDTO dto) {
        return dto.saldo() == null || dto.saldo().compareTo(BigDecimal.ZERO) < 0;
    }

    public static boolean isTipoContaInvalid(ContaDTO dto) {
        try {
            TipoContaEnum.valueOf(dto.tipoConta().name());
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public void validateContaDTO(ContaDTO dto) {
        if (isNumeroEmpty(dto)) throw new ContaException.NumeroVazioException();
        if (isDigitoInvalid(dto)) throw new ContaException.DigitoInvalidoException();
        if (isSaldoInvalid(dto)) throw new ContaException.SaldoInvalidoException();
        if(isTipoContaInvalid(dto)) throw new ContaException.TipoContaInvalidoException();
    }
}
