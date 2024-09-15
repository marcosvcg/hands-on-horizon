package com.marcosvcg.handsonhorizon.model.dto;

import com.marcosvcg.handsonhorizon.model.entities.Conta;
import com.marcosvcg.handsonhorizon.util.TipoContaEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record ContaDTO (
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        UUID id,
        UUID pessoaId,
        @Schema(example = "18201872")
        String numero,
        @Schema(example = "4")
        int digito,
        @Schema(example = "1000.00")
        BigDecimal saldo,
        @Schema(example = "CORRENTE")
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

    public ContaDTO atualizarSaldo(BigDecimal novoSaldo) {
        return ContaDTO.builder()
                .id(this.id)
                .pessoaId(this.pessoaId)
                .numero(this.numero)
                .digito(this.digito)
                .saldo(novoSaldo)  // Atualiza apenas o saldo
                .tipoConta(this.tipoConta)
                .build();
    }
}
