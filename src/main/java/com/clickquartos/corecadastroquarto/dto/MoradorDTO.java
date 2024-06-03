package com.clickquartos.corecadastroquarto.dto;

import com.clickquartos.corecadastroquarto.enums.EstadoCivilEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.EAN;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoradorDTO {

    private String nomeCompleto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @CPF
    private String cpf;

    private String rg;

    private String telefone;

    @Email
    private String email;

    private EnderecoDTO endereco;

    private String empresa;

    private String cargo;

    private EstadoCivilEnum estadoCivil;

    private String codigoQuarto;

}
