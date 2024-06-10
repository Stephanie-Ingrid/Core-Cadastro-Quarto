package com.clickquartos.corecadastroquarto.dto;

import com.clickquartos.corecadastroquarto.enums.DisponibilidadeEnum;
import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
