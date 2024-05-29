package com.clickquartos.corecadastroquarto.service;

import com.clickquartos.corecadastroquarto.dto.QuartoDTO;

import java.util.List;

public interface QuartoService {

    QuartoDTO createQuarto( QuartoDTO quartoDTO );

    List< QuartoDTO > findAll();

    void updateQuarto( String codigoQuarto, QuartoDTO quartoDTO );

    void deleteQuarto( String codigoQuarto );
}
