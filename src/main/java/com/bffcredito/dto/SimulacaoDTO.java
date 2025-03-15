package com.bffcredito.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimulacaoDTO {

    @NotNull(message = "O valor não pode ser nulo")
    @Min(value = 1000, message = "O valor mínimo da simulação é R$ 1.000,00")
    private Double valor;

    @NotNull(message = "O prazo não pode ser nulo")
    @Min(value = 6, message = "O prazo mínimo é de 6 meses")
    private Integer prazo;

    @NotNull(message = "A taxa de juros não pode ser nula")
    @Min(value = 1, message = "A taxa de juros deve ser maior que 0")
    private Double taxaJuros;

    private Double valorParcela;
}
