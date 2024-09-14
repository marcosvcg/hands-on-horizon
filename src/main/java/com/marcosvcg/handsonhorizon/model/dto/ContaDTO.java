package com.marcosvcg.handsonhorizon.model.dto;

import com.marcosvcg.handsonhorizon.model.entities.Conta;
import com.marcosvcg.handsonhorizon.model.entities.Pessoa;
import com.marcosvcg.handsonhorizon.util.TipoContaEnum;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record ContaDTO (
        UUID id,
        String numero,
        int digito,
        BigDecimal saldo,
        TipoContaEnum tipoConta,
        Pessoa pessoa
) {
    public static ContaDTO toDto(Conta conta) {
        return ContaDTO.builder()
                .id(conta.getId())
                .numero(conta.getNumero())
                .digito(conta.getDigito())
                .saldo(conta.getSaldo())
                .tipoConta(conta.getTipoConta())
                .pessoa(conta.getPessoa())
                .build();
    }

    public static Conta toEntity(ContaDTO dto) {
        return new Conta(
          dto.id(),
          dto.numero(),
          dto.digito(),
          dto.saldo(),
          dto.tipoConta(),
          dto.pessoa()
        );
    }
}
