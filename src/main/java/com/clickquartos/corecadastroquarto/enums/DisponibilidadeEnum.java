package com.clickquartos.corecadastroquarto.enums;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@NotNull
@NotBlank
public enum DisponibilidadeEnum {

    DISPONIVEL,
    ALUGADO

}
