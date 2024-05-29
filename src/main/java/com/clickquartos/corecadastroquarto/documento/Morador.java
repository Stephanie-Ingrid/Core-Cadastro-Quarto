package com.clickquartos.corecadastroquarto.documento;

import com.clickquartos.corecadastroquarto.enums.EstadoCivilEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Morador {

    private String nomeCompleto;

    private LocalDate dataNascimento;

    private String cpf;

    private String rg;

    private String telefone;

    private Endereco endereco;

    private String empresa;

    private String cargo;

    private EstadoCivilEnum estadoCivil;


}
