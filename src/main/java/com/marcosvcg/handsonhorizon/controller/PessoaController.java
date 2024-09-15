package com.marcosvcg.handsonhorizon.controller;

import com.marcosvcg.handsonhorizon.model.dto.PessoaDTO;
import com.marcosvcg.handsonhorizon.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @Operation(description = "Retorna uma lista com as pessoas")
    @GetMapping
    public List<PessoaDTO> getPessoas() {
        return pessoaService.getPessoas();
    }

    @Operation(description = "Busca uma pessoa pelo identificador")
    @GetMapping("/{pessoaId}")
    public PessoaDTO getPessoaById(@PathVariable("pessoaId") UUID id) {
        return pessoaService.getPessoaByID(id);
    }

    @Operation(description = "Busca uma pessoa pelo nome")
    @GetMapping("/nome")
    public PessoaDTO getPessoaByNome(@RequestParam("nome") String nome) {
        return pessoaService.getPessoaByNome(nome);
    }

    @Operation(description = "Cria uma pessoa. O ID já é gerado automaticamente.")
    @PostMapping
    public void createPessoa(@RequestBody PessoaDTO pessoaDTO) {
        pessoaService.createPessoa(pessoaDTO);
    }
}
