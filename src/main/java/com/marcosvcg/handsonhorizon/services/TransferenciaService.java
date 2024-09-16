package com.marcosvcg.handsonhorizon.services;

import com.marcosvcg.handsonhorizon.model.dto.ContaDTO;
import com.marcosvcg.handsonhorizon.model.dto.TransferenciaDTO;
import com.marcosvcg.handsonhorizon.model.entities.Transferencia;
import com.marcosvcg.handsonhorizon.repository.TransferenciaRepository;
import com.marcosvcg.handsonhorizon.validator.ValidateTransferenciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final ContaService contaService;
    private final PessoaService pessoaService;
    private final ValidateTransferenciaDTO validator = new ValidateTransferenciaDTO();

    @Autowired
    public TransferenciaService(TransferenciaRepository transferenciaRepository, ContaService contaService, PessoaService pessoaService) {
        this.transferenciaRepository = transferenciaRepository;
        this.contaService = contaService;
        this.pessoaService = pessoaService;
    }

    public List<TransferenciaDTO> getTransferencias() {
        return transferenciaRepository.findAll().stream()
                .map(TransferenciaDTO::toDTO)
                .collect(Collectors.toList());
    }

    public void transferir(TransferenciaDTO transferenciaDto) {
        ContaDTO contaOrigemDto = contaService.getContaById(transferenciaDto.contaOrigemId());
        ContaDTO contaDestinoDto = contaService.getContaById(transferenciaDto.contaDestinoId());

        validator.validateTransferenciaDTO(transferenciaDto, contaOrigemDto, contaDestinoDto);

        ContaDTO contaOrigemAtualizada = contaService.subtrairSaldo(contaOrigemDto, transferenciaDto.valor());
        ContaDTO contaDestinoAtualizada = contaService.adicionarSaldo(contaDestinoDto, transferenciaDto.valor());

        contaService.updateConta(contaOrigemAtualizada);
        contaService.updateConta(contaDestinoAtualizada);

        Transferencia transferencia = TransferenciaDTO.toEntity(transferenciaDto,
                ContaDTO.toEntity(contaOrigemDto, pessoaService.getPessoaByID(contaOrigemDto.pessoaId())),
                ContaDTO.toEntity(contaDestinoDto, pessoaService.getPessoaByID(contaDestinoDto.pessoaId())));

        transferenciaRepository.save(transferencia);
    }
}
