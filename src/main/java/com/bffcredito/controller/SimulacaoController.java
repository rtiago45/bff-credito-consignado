package com.bffcredito.controller;

import com.bffcredito.dto.SimulacaoDTO;
import com.bffcredito.service.SimulacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulacao")
public class SimulacaoController {

    private final SimulacaoService simulacaoService;

    public SimulacaoController(SimulacaoService simulacaoService) {
        this.simulacaoService = simulacaoService;
    }

    @PostMapping
    public ResponseEntity<SimulacaoDTO> criarSimulacao(@RequestBody SimulacaoDTO simulacaoDTO) {
        SimulacaoDTO resultado = simulacaoService.salvarSimulacao(simulacaoDTO);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public ResponseEntity<List<SimulacaoDTO>> listarSimulacoes() {
        return ResponseEntity.ok(simulacaoService.listarSimulacoes());
    }
}
