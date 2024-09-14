package com.marcosvcg.handsonhorizon.services;

import com.marcosvcg.handsonhorizon.exceptions.PessoaException;
import com.marcosvcg.handsonhorizon.model.dto.PessoaDTO;
import com.marcosvcg.handsonhorizon.repository.PessoaRepository;
import com.marcosvcg.handsonhorizon.validator.ValidatePessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ValidatePessoaDTO validator = new ValidatePessoaDTO();

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<PessoaDTO> getPessoas() {
        return pessoaRepository.findAll().stream()
                .map(PessoaDTO::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO getPessoaByID(UUID id) {
        return pessoaRepository.findById(id)
                .map(PessoaDTO::toDTO)
                .orElseThrow(PessoaException.PessoaNotFoundException::new);
    }

    public PessoaDTO getPessoaByNome(String nome) {
        return pessoaRepository.findByNome(nome)
                .map(PessoaDTO::toDTO)
                .orElseThrow(PessoaException.PessoaNotFoundException::new);
    }

    public void createPessoa(PessoaDTO dto) {
        validator.validatePessoaDTO(dto);
        if(pessoaRepository.findByCpf(dto.cpf()).isPresent()) throw new PessoaException.CpfRegistradoException();
        pessoaRepository.save(PessoaDTO.toEntity(dto));
    }
}
