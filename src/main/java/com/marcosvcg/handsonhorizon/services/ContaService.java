package com.marcosvcg.handsonhorizon.services;

import com.marcosvcg.handsonhorizon.exceptions.ContaException;
import com.marcosvcg.handsonhorizon.model.dto.ContaDTO;
import com.marcosvcg.handsonhorizon.model.dto.PessoaDTO;
import com.marcosvcg.handsonhorizon.model.entities.Conta;
import com.marcosvcg.handsonhorizon.repository.ContaRepository;
import com.marcosvcg.handsonhorizon.validator.ValidateContaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ContaService {

    private final ContaRepository contaRepository;
    private final PessoaService pessoaService;
    private final ValidateContaDTO validator = new ValidateContaDTO();

    @Autowired
    public ContaService(ContaRepository contaRepository, PessoaService pessoaService) {
        this.contaRepository = contaRepository;
        this.pessoaService = pessoaService;
    }

    public List<ContaDTO> getContas() {
        return contaRepository.findAll().stream()
                .map(ContaDTO::toDTO)
                .collect(Collectors.toList());
    }

    public ContaDTO getContaById(UUID id) {
        return contaRepository.findById(id)
                .map(ContaDTO::toDTO)
                .orElseThrow(ContaException.ContaNotFoundException::new);
    }

    public void createConta(ContaDTO contaDto) {
        PessoaDTO pessoaDto = pessoaService.getPessoaByID(contaDto.pessoaId());
        validator.validateContaDTO(contaDto);

        Optional<Conta> contaExistente = contaRepository.findByPessoaIdAndTipoConta(contaDto.pessoaId(), contaDto.tipoConta());
        if(contaExistente.isPresent()) throw new ContaException.TipoContaExistenteException();

        contaRepository.save(ContaDTO.toEntity(contaDto, pessoaDto));
    }

    public void updateConta(ContaDTO dto) {
        ContaDTO contaExistenteDto = getContaById(dto.id());
        validator.validateContaDTO(dto);

        ContaDTO contaAtualizadaDto = dto.atualizarSaldo(dto.saldo());

        contaRepository.save(ContaDTO.toEntity(
                contaAtualizadaDto,
                pessoaService.getPessoaByID(contaExistenteDto.pessoaId()))
        );
    }

    public ContaDTO subtrairSaldo(ContaDTO contaOrigemDto, BigDecimal valor) {
        if(ValidateContaDTO.isValorInvalid(valor)) throw new ContaException.ValorInvalidoException();
        if(ValidateContaDTO.isSaldoInvalid(contaOrigemDto)) throw new ContaException.SaldoInvalidoException();
        BigDecimal saldoAtualizado = contaOrigemDto.saldo().subtract(valor);

        return contaOrigemDto.atualizarSaldo(saldoAtualizado);
    }

    public ContaDTO adicionarSaldo(ContaDTO contaDestinoDto, BigDecimal valor) {
        if(ValidateContaDTO.isValorInvalid(valor)) throw new ContaException.ValorInvalidoException();
        BigDecimal saldoAtualizado = contaDestinoDto.saldo().add(valor);

        return contaDestinoDto.atualizarSaldo(saldoAtualizado);
    }

    public BigDecimal consultarSaldo(UUID id) {
        ContaDTO dto = getContaById(id);
        if(ValidateContaDTO.isSaldoInvalid(dto)) throw new ContaException.SaldoInvalidoException();
        return dto.saldo();
    }
}
