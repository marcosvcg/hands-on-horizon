package com.marcosvcg.handsonhorizon.validator;

import com.marcosvcg.handsonhorizon.model.dto.ContaDTO;

import java.math.BigDecimal;

public class ValidateTransferenciaDTO {

    public static boolean isValorInvalid(BigDecimal valor) {
        return valor == null || valor.compareTo(BigDecimal.ZERO) < 0;
    }

    public static boolean isTransferenciaInvalid(ContaDTO contaOrigem, ContaDTO contaDestino) {
        return contaOrigem.id().equals(contaDestino.id());
    }
}
