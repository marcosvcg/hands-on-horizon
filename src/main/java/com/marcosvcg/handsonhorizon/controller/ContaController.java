package com.marcosvcg.handsonhorizon.controller;

import com.marcosvcg.handsonhorizon.model.dto.ContaDTO;
import com.marcosvcg.handsonhorizon.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public List<ContaDTO> getContas() {
        return contaService.getContas();
    }

    @GetMapping("/{contaId}")
    public ContaDTO getContaById(@PathVariable("contaId") UUID id) {
        return contaService.getContaById(id);
    }

    @PostMapping
    public void createConta(@RequestBody ContaDTO contaDTO) {
        contaService.createConta(contaDTO);
    }

    @GetMapping("/{contaId}/saldo")
    public BigDecimal consultarSaldo(@PathVariable("contaId") UUID id) {
        return contaService.consultarSaldo(id);
    }

    @PostMapping("/{contaId}/deposito")
    public void deposito(@PathVariable("contaId") UUID id, @RequestBody BigDecimal valor) {
        ContaDTO dto = contaService.getContaById(id);
        ContaDTO contaAtualizadaDto = contaService.adicionarSaldo(dto, valor);
        contaService.updateConta(contaAtualizadaDto);
    }

    @PostMapping("/{contaId}/saque")
    public void saque(@PathVariable("contaId") UUID id, @RequestBody BigDecimal valor) {
        ContaDTO dto = contaService.getContaById(id);
        ContaDTO contaAtualizadaDto = contaService.subtrairSaldo(dto, valor);
        contaService.updateConta(contaAtualizadaDto);
    }
}
