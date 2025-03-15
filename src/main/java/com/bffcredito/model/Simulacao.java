package com.bffcredito.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Simulacao {

    private Double valor;
    private Integer prazo;
    private Double taxaJuros;
    private Double valorParcela;

    public Simulacao(Double valor, Integer prazo, Double taxaJuros) {
        this.valor = valor;
        this.prazo = prazo;
        this.taxaJuros = taxaJuros;
        this.valorParcela = calcularValorParcela();
    }

    private Double calcularValorParcela() {
        double taxaDecimal = taxaJuros / 100;
        return (valor * taxaDecimal) / (1 - Math.pow(1 + taxaDecimal, -prazo));
    }
}
