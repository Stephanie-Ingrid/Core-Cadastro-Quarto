package com.clickquartos.corecadastroquarto.integration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisparoEmailRequest {

    private String destinatario;

    private String assunto;

    private String corpo;


}
