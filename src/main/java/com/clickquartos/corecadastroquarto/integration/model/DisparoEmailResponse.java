package com.clickquartos.corecadastroquarto.integration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisparoEmailResponse {

    private String destinatario;

    private String assunto;

    private String corpo;

    private LocalDateTime dataHora;

}
