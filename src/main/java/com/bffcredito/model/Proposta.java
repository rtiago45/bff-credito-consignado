package com.bffcredito.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // Construtor com argumentos
@NoArgsConstructor  // Construtor sem argumentos
public class Proposta {
    private Long id;
    private Long clienteId;
    private Double valor;
    private Integer prazo;
    private String status;

    public Proposta(Long aLong, Long clienteId, Double valor, Integer prazo) {
    }

    public void aprovar() {
        this.status = "APROVADA";
    }

    public void reprovar() {
        this.status = "REPROVADA";
    }
}
