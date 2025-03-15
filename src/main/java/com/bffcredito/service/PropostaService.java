package com.bffcredito.service;

import com.bffcredito.dto.PropostaDTO;
import com.bffcredito.model.Proposta;
import com.bffcredito.repository.PropostaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropostaService {

    private final PropostaRepository propostaRepository;
    private Long proximoId = 1L; // Simula auto-incremento para ID das propostas

    public PropostaService(PropostaRepository propostaRepository) {
        this.propostaRepository = propostaRepository;
    }

    public PropostaDTO criarProposta(PropostaDTO propostaDTO) {
        Proposta proposta = new Proposta(proximoId++, propostaDTO.getClienteId(), propostaDTO.getValor(), propostaDTO.getPrazo());
        propostaRepository.salvarProposta(proposta);

        propostaDTO.setId(proposta.getId());
        propostaDTO.setStatus(proposta.getStatus());
        return propostaDTO;
    }

    public PropostaDTO obterProposta(Long id) {
        Proposta proposta = propostaRepository.obterProposta(id);
        if (proposta == null) return null;

        return new PropostaDTO(proposta.getId(), proposta.getClienteId(), proposta.getValor(), proposta.getPrazo(), proposta.getStatus());
    }

    public List<PropostaDTO> listarPropostas() {
        return propostaRepository.listarPropostas().stream()
                .map(proposta -> new PropostaDTO(proposta.getId(), proposta.getClienteId(), proposta.getValor(), proposta.getPrazo(), proposta.getStatus()))
                .collect(Collectors.toList());
    }

    public PropostaDTO aprovarProposta(Long id) {
        Proposta proposta = propostaRepository.obterProposta(id);
        if (proposta == null) return null;

        proposta.aprovar();
        propostaRepository.salvarProposta(proposta);

        return new PropostaDTO(proposta.getId(), proposta.getClienteId(), proposta.getValor(), proposta.getPrazo(), proposta.getStatus());
    }

    public PropostaDTO reprovarProposta(Long id) {
        Proposta proposta = propostaRepository.obterProposta(id);
        if (proposta == null) return null;

        proposta.reprovar();
        propostaRepository.salvarProposta(proposta);

        return new PropostaDTO(proposta.getId(), proposta.getClienteId(), proposta.getValor(), proposta.getPrazo(), proposta.getStatus());
    }
}
