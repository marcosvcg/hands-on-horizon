package com.marcosvcg.handsonhorizon.controller;

import com.marcosvcg.handsonhorizon.model.dto.ContaDTO;
import com.marcosvcg.handsonhorizon.services.ContaService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(description = "Retorna uma lista com as contas")
    @GetMapping
    public List<ContaDTO> getContas() {
        return contaService.getContas();
    }

    @Operation(description = "Busca uma conta bancária pelo identificador")
    @GetMapping("/{contaId}")
    public ContaDTO getContaById(@PathVariable("contaId") UUID id) {
        return contaService.getContaById(id);
    }

    @Operation(description = "Cria uma conta bancária, com a mesma podendo ser do tipo \"CORRENTE\" ou \"POUPANCA\". O ID já é gerado automaticamente.")
    @PostMapping
    public void createConta(@RequestBody ContaDTO contaDTO) {
        contaService.createConta(contaDTO);
    }

    @Operation(description = "Consulta o saldo pelo id da conta")
    @GetMapping("/{contaId}/saldo")
    public BigDecimal consultarSaldo(@PathVariable("contaId") UUID id) {
        return contaService.consultarSaldo(id);
    }

    @Operation(description = "Efetua o depósito na conta")
    @PostMapping("/{contaId}/deposito")
    public void deposito(@PathVariable("contaId") UUID id, @RequestBody BigDecimal valor) {
        ContaDTO dto = contaService.getContaById(id);
        ContaDTO contaAtualizadaDto = contaService.adicionarSaldo(dto, valor);
        contaService.updateConta(contaAtualizadaDto);
    }

    @Operation(description = "Efetua o saque da conta")
    @PostMapping("/{contaId}/saque")
    public void saque(@PathVariable("contaId") UUID id, @RequestBody BigDecimal valor) {
        ContaDTO dto = contaService.getContaById(id);
        ContaDTO contaAtualizadaDto = contaService.subtrairSaldo(dto, valor);
        contaService.updateConta(contaAtualizadaDto);
    }
}
