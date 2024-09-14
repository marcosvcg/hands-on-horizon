package com.marcosvcg.handsonhorizon.validator;

import com.marcosvcg.handsonhorizon.exceptions.Exceptions;
import com.marcosvcg.handsonhorizon.model.dto.PessoaDTO;

public class ValidatePessoaDTO {

    public boolean isNomeEmpty(PessoaDTO dto) {
        return dto.nome().isBlank();
    }

    public boolean isTelefoneEmpty(PessoaDTO dto) {
        return dto.telefone().isBlank();
    }

    public boolean isCpfEmpty(PessoaDTO dto) {
        return dto.cpf().isBlank();
    }

    public void validatePessoaDTO(PessoaDTO dto) {
        if (isNomeEmpty(dto)) throw new Exceptions.NomeVazioException();
        if (isTelefoneEmpty(dto)) throw new Exceptions.TelefoneVazioException();
        if (isCpfEmpty(dto)) throw new Exceptions.CpfVazioException();
    }
}
