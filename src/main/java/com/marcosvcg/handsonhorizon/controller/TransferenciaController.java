package com.marcosvcg.handsonhorizon.controller;

import com.marcosvcg.handsonhorizon.model.dto.TransferenciaDTO;
import com.marcosvcg.handsonhorizon.services.TransferenciaService;
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

    @GetMapping
    public List<TransferenciaDTO> getTransferencias() {
        return transferenciaService.getTransferencias();
    }

    @PostMapping
    public void transferir(@RequestBody TransferenciaDTO transferenciaDTO) {
        transferenciaService.transferir(transferenciaDTO);
    }
}
