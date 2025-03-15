package com.bffcredito.service;

import com.bffcredito.dto.SimulacaoDTO;
import com.bffcredito.model.Simulacao;
import com.bffcredito.repository.SimulacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimulacaoService {

    private final SimulacaoRepository simulacaoRepository;

    public SimulacaoService(SimulacaoRepository simulacaoRepository) {
        this.simulacaoRepository = simulacaoRepository;
    }

    public SimulacaoDTO salvarSimulacao(SimulacaoDTO simulacaoDTO) {
        Simulacao simulacao = new Simulacao(
                simulacaoDTO.getValor(),
                simulacaoDTO.getPrazo(),
                simulacaoDTO.getTaxaJuros()
        );

        simulacaoRepository.salvarSimulacao(simulacao);

        simulacaoDTO.setValorParcela(simulacao.getValorParcela());
        return simulacaoDTO;
    }

    public List<SimulacaoDTO> listarSimulacoes() {
        return simulacaoRepository.listarSimulacoes().stream()
                .map(simulacao -> {
                    SimulacaoDTO dto = new SimulacaoDTO();
                    dto.setValor(simulacao.getValor());
                    dto.setPrazo(simulacao.getPrazo());
                    dto.setTaxaJuros(simulacao.getTaxaJuros());
                    dto.setValorParcela(simulacao.getValorParcela());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
