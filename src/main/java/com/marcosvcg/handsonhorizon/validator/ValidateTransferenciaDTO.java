package com.marcosvcg.handsonhorizon.validator;

import com.marcosvcg.handsonhorizon.exceptions.TransferenciaException;
import com.marcosvcg.handsonhorizon.model.dto.ContaDTO;
import com.marcosvcg.handsonhorizon.model.dto.TransferenciaDTO;
import com.marcosvcg.handsonhorizon.util.ValidationHelper;

import java.math.BigDecimal;

public class ValidateTransferenciaDTO {

    public static boolean isTransferenciaInvalid(ContaDTO contaOrigem, ContaDTO contaDestino) {
        return contaOrigem.id().equals(contaDestino.id());
    }

    public static boolean isSaldoInvalid(ContaDTO dto) {
        return dto.saldo() == null || dto.saldo().compareTo(BigDecimal.ZERO) < 0;
    }

    public static boolean isValorInvalid(TransferenciaDTO dto) {
        return dto.valor() == null || dto.valor().compareTo(BigDecimal.ZERO) <= 0;
    }

    public static boolean isDataInvalid(TransferenciaDTO dto) {
        String dataEmString = dto.data().format(ValidationHelper.FORMATTER);
        return !ValidationHelper.isDataValid(dataEmString);
    }

    public void validateTransferenciaDTO(TransferenciaDTO dto, ContaDTO contaOrigem, ContaDTO contaDestino) {
        if(isValorInvalid(dto)) throw new TransferenciaException.ValorInvalidoException();
        if(isSaldoInvalid(contaOrigem)) throw new TransferenciaException.SaldoInsuficienteException();
        if(isDataInvalid(dto)) throw new TransferenciaException.DataInvalidaException();
        if(isTransferenciaInvalid(contaOrigem, contaDestino)) throw new TransferenciaException.ContaInvalidaException();
    }
}