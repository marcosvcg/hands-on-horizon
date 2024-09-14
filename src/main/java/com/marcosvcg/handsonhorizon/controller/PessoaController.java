package com.marcosvcg.handsonhorizon.controller;

import com.marcosvcg.handsonhorizon.model.dto.PessoaDTO;
import com.marcosvcg.handsonhorizon.services.PessoaService;
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

    @GetMapping
    public List<PessoaDTO> getPessoas() {
        return pessoaService.getPessoas();
    }

    @GetMapping("/{pessoaId}")
    public PessoaDTO getPessoaById(@PathVariable("pessoaId") UUID id) {
        return pessoaService.getPessoaByID(id);
    }

    @GetMapping("/nome")
    public PessoaDTO getPessoaByNome(@RequestParam("nome") String nome) {
        return pessoaService.getPessoaByNome(nome);
    }

    @PostMapping
    public void createPessoa(@RequestBody PessoaDTO pessoaDTO) {
        pessoaService.createPessoa(pessoaDTO);
    }
}
