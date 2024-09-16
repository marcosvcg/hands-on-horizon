package com.marcosvcg.handsonhorizon.model.dto;

import com.marcosvcg.handsonhorizon.model.entities.Pessoa;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.UUID;

@Builder
public record PessoaDTO (
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        UUID id,
        @Schema(example = "Pedro")
        String nome,
        @Schema(example = "71987654321")
        String telefone,
        @Schema(example = "01234567890")
        String cpf
) {
    public static PessoaDTO toDTO(Pessoa pessoa) {
        return PessoaDTO.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome().trim())
                .telefone(pessoa.getTelefone())
                .cpf(pessoa.getCpf())
                .build();
    }

    public static Pessoa toEntity(PessoaDTO dto) {
        return new Pessoa(
                dto.id(),
                dto.nome().trim(),
                dto.telefone(),
                dto.cpf()
        );
    }
}
