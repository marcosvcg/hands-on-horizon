package com.marcosvcg.handsonhorizon.model.dto;

import com.marcosvcg.handsonhorizon.model.entities.Transferencia;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Builder
public record TransferenciaDTO (
        UUID id,
        UUID contaOrigem,
        UUID contaDestino,
        BigDecimal valor,
        Date data
) {
    public static TransferenciaDTO toDTO(Transferencia transferencia) {
        return TransferenciaDTO.builder()
                .id(transferencia.getId())
                .contaOrigem(transferencia.getContaOrigem().getId())
                .contaDestino(transferencia.getContaDestino().getId())
                .valor(transferencia.getValor())
                .data(transferencia.getData())
                .build();
    }

    public static Transferencia toEntity(TransferenciaDTO dto) {
        return new Transferencia(
                dto.id(),
                dto.valor(),
                dto.data()
        );
    }
}
