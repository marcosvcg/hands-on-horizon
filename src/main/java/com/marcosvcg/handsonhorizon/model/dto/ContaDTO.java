package com.marcosvcg.handsonhorizon.model.dto;

import com.marcosvcg.handsonhorizon.model.entities.Conta;
import com.marcosvcg.handsonhorizon.util.TipoContaEnum;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record ContaDTO (
        UUID id,
        UUID pessoaId,
        String numero,
        int digito,
        BigDecimal saldo,
        TipoContaEnum tipoConta
) {
    public static ContaDTO toDTO(Conta conta) {
        return ContaDTO.builder()
                .id(conta.getId())
                .pessoaId(conta.getPessoa().getId())
                .numero(conta.getNumero())
                .digito(conta.getDigito())
                .saldo(conta.getSaldo())
                .tipoConta(conta.getTipoConta())
                .build();
    }

    public static Conta toEntity(ContaDTO dto, PessoaDTO pessoaDto) {
        return new Conta(
          dto.id(),
          PessoaDTO.toEntity(pessoaDto),
          dto.numero(),
          dto.digito(),
          dto.saldo(),
          dto.tipoConta()
        );
    }
}
