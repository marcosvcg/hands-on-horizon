package com.marcosvcg.handsonhorizon.validator;

import com.marcosvcg.handsonhorizon.model.dto.ContaDTO;

import java.math.BigDecimal;

public class ValidateTransferenciaDTO {

    public static boolean isTransferenciaInvalid(ContaDTO contaOrigem, ContaDTO contaDestino) {
        return contaOrigem.id().equals(contaDestino.id());
    }

    public static boolean isSaldoInvalid(ContaDTO dto) {
        return dto.saldo() == null || dto.saldo().compareTo(BigDecimal.ZERO) < 0;
    }
}
