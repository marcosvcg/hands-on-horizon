package com.marcosvcg.handsonhorizon.controller;

import com.marcosvcg.handsonhorizon.model.dto.TransferenciaDTO;
import com.marcosvcg.handsonhorizon.services.TransferenciaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @Operation(description = "Retorna uma lista com as transferências")
    @GetMapping
    public List<TransferenciaDTO> getTransferencias() {
        return transferenciaService.getTransferencias();
    }

    @Operation(description = """
            Realiza a transferência de uma conta origem para uma conta destino, referenciando pelo ID de cada. O ID já é gerado automaticamente.

            O formato da data segue esse padrão: 15/09/2024 16:00:00""")
    @PostMapping
    public void transferir(@RequestBody TransferenciaDTO transferenciaDTO) {
        transferenciaService.transferir(transferenciaDTO);
    }
}
