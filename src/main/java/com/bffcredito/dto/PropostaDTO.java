package com.bffcredito.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // Gera um construtor com todos os atributos
@NoArgsConstructor  // Gera um construtor sem argumentos (obrigatório para serialização JSON)
public class PropostaDTO {
    private Long id;
    private Long clienteId;
    private Double valor;
    private Integer prazo;
    private String status;
}
