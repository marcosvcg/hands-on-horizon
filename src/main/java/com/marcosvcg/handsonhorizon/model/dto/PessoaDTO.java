package com.marcosvcg.handsonhorizon.model.dto;

import com.marcosvcg.handsonhorizon.model.entities.Pessoa;
import lombok.Builder;

import java.util.UUID;

@Builder
public record PessoaDTO (
        UUID id,
        String nome,
        String telefone,
        String cpf,
        ContaDTO contaCorrenteDto,
        ContaDTO contaPoupancaDto
) {
    public static PessoaDTO toDTO(Pessoa pessoa) {
        return PessoaDTO.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .telefone(pessoa.getTelefone())
                .cpf(pessoa.getCpf())
                .contaCorrenteDto(ContaDTO.toDto(pessoa.getContaCorrente()))
                .contaPoupancaDto(ContaDTO.toDto(pessoa.getContaPoupanca()))
                .build();
    }

    public static Pessoa toEntity(PessoaDTO dto) {
        return new Pessoa(
                dto.id(),
                dto.nome(),
                dto.telefone(),
                dto.cpf(),
                ContaDTO.toEntity(dto.contaCorrenteDto()),
                ContaDTO.toEntity(dto.contaPoupancaDto())
        );
    }
}
