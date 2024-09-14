package com.marcosvcg.handsonhorizon.model.dto;

import com.marcosvcg.handsonhorizon.model.entities.Conta;
import com.marcosvcg.handsonhorizon.model.entities.Transferencia;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Builder
public record TransferenciaDTO (
        UUID id,
        Conta contaOrigem,
        Conta contaDestino,
        BigDecimal valor,
        Date data
) {
    public static TransferenciaDTO toDTO(Transferencia transferencia) {
        return TransferenciaDTO.builder()
                .id(transferencia.getId())
                .contaOrigem(transferencia.getContaOrigem())
                .contaDestino(transferencia.getContaDestino())
                .valor(transferencia.getValor())
                .data(transferencia.getData())
                .build();
    }

    public static Transferencia toEntity(TransferenciaDTO dto) {
        return new Transferencia(
                dto.id(),
                dto.contaOrigem(),
                dto.contaDestino(),
                dto.valor(),
                dto.data()
        );
    }
}
