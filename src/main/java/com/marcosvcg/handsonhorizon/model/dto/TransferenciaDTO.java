package com.marcosvcg.handsonhorizon.model.dto;

import com.marcosvcg.handsonhorizon.model.entities.Transferencia;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Builder
public record TransferenciaDTO (
        UUID id,
        ContaDTO contaOrigem,
        ContaDTO contaDestino,
        BigDecimal valor,
        Date data
) {
    public static TransferenciaDTO toDTO(Transferencia transferencia) {
        return TransferenciaDTO.builder()
                .id(transferencia.getId())
                .contaOrigem(ContaDTO.toDto(transferencia.getContaOrigem()))
                .contaDestino(ContaDTO.toDto(transferencia.getContaDestino()))
                .valor(transferencia.getValor())
                .data(transferencia.getData())
                .build();
    }

    public static Transferencia toEntity(TransferenciaDTO dto) {
        return new Transferencia(
                dto.id(),
                ContaDTO.toEntity(dto.contaOrigem()),
                ContaDTO.toEntity(dto.contaDestino()),
                dto.valor(),
                dto.data()
        );
    }
}
