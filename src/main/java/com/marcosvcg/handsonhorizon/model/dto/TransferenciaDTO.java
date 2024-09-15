package com.marcosvcg.handsonhorizon.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcosvcg.handsonhorizon.model.entities.Conta;
import com.marcosvcg.handsonhorizon.model.entities.Transferencia;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Builder
public record TransferenciaDTO (
        UUID id,
        UUID contaOrigemId,
        UUID contaDestinoId,
        BigDecimal valor,

        @Schema(description = "Data da transferência", example = "15/09/2024 16:00:00")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        Date data
) {
    public static TransferenciaDTO toDTO(Transferencia transferencia) {
        return TransferenciaDTO.builder()
                .id(transferencia.getId())
                .contaOrigemId(transferencia.getContaOrigem().getId())
                .contaDestinoId(transferencia.getContaDestino().getId())
                .valor(transferencia.getValor())
                .data(transferencia.getData())
                .build();
    }

    public static Transferencia toEntity(TransferenciaDTO dto, Conta contaOrigem, Conta contaDestino) {
        return new Transferencia(
                dto.id(),
                contaOrigem,
                contaDestino,
                dto.valor(),
                dto.data()
        );
    }
}
