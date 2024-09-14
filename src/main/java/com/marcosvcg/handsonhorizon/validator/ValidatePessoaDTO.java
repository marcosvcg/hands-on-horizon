package com.marcosvcg.handsonhorizon.validator;

import com.marcosvcg.handsonhorizon.exceptions.PessoaException;
import com.marcosvcg.handsonhorizon.model.dto.PessoaDTO;
import com.marcosvcg.handsonhorizon.util.ValidationHelper;

public class ValidatePessoaDTO {

    public static boolean isNomeEmpty(PessoaDTO dto) {
        return dto.nome().isBlank();
    }

    public static boolean isTelefoneValid(PessoaDTO dto) {
        if(dto.telefone().isBlank()) throw new PessoaException.TelefoneVazioException();
        return !ValidationHelper.isTelefoneValid(dto.telefone());
    }

    public static boolean isCpfValid(PessoaDTO dto) {
        if(dto.cpf().isBlank()) throw new PessoaException.CpfVazioException();
        return !ValidationHelper.isCpfValid(dto.cpf());
    }

    public void validatePessoaDTO(PessoaDTO dto) {
        if (isNomeEmpty(dto)) throw new PessoaException.NomeVazioException();
        if (isTelefoneValid(dto)) throw new PessoaException.TelefoneInvalidoException();
        if (isCpfValid(dto)) throw new PessoaException.CpfInvalidoException();
    }
}
