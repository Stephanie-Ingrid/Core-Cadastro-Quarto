package com.clickquartos.corecadastroquarto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuartoDTO{

    private String codigoQuarto;

    private String disponibilidade;

    private BigDecimal valor;

    private String descricao;

}
