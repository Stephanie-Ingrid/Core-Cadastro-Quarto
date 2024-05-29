package com.clickquartos.corecadastroquarto.documento;

import com.clickquartos.corecadastroquarto.enums.DisponibilidadeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "quarto")
public class Quarto {

    @Id
    private String codigoQuarto;

    private DisponibilidadeEnum disponibilidade;

    private BigDecimal valor;

    private String descricao;

    private Morador morador;

}
