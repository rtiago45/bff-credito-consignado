package com.bffcredito.controller;

import com.bffcredito.dto.PropostaDTO;
import com.bffcredito.service.PropostaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    private final PropostaService propostaService;

    public PropostaController(PropostaService propostaService) {
        this.propostaService = propostaService;
    }

    @PostMapping
    public ResponseEntity<PropostaDTO> criarProposta(@RequestBody PropostaDTO propostaDTO) {
        return ResponseEntity.ok(propostaService.criarProposta(propostaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropostaDTO> obterProposta(@PathVariable Long id) {
        return ResponseEntity.ok(propostaService.obterProposta(id));
    }

    @GetMapping
    public ResponseEntity<List<PropostaDTO>> listarPropostas() {
        return ResponseEntity.ok(propostaService.listarPropostas());
    }

    @PutMapping("/{id}/aprovar")
    public ResponseEntity<PropostaDTO> aprovarProposta(@PathVariable Long id) {
        return ResponseEntity.ok(propostaService.aprovarProposta(id));
    }

    @PutMapping("/{id}/reprovar")
    public ResponseEntity<PropostaDTO> reprovarProposta(@PathVariable Long id) {
        return ResponseEntity.ok(propostaService.reprovarProposta(id));
    }
}
