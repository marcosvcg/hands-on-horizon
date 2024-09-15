package com.marcosvcg.handsonhorizon.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcosvcg.handsonhorizon.model.entities.Conta;
import com.marcosvcg.handsonhorizon.model.entities.Transferencia;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record TransferenciaDTO (
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        UUID id,
        UUID contaOrigemId,
        UUID contaDestinoId,
        @Schema(example = "150.00")
        BigDecimal valor,
        @Schema(type = "string", example = "15/09/2024 20:00:00", pattern = "dd/MM/yyyy HH:mm:ss")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime data
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
