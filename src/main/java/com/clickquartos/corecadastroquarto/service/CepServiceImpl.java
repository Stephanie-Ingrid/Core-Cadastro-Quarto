package com.clickquartos.corecadastroquarto.service;

import com.clickquartos.corecadastroquarto.dto.EnderecoDTO;
import com.clickquartos.corecadastroquarto.exception.erros.NotFoundException;
import com.clickquartos.corecadastroquarto.integration.CepIntegration;
import com.clickquartos.corecadastroquarto.integration.model.EnderecoResponse;
import com.clickquartos.corecadastroquarto.repository.QuartoRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Data
public class CepServiceImpl implements CepService{

    private ModelMapper modelMapper;

    private QuartoRepository quartoRepository;

    private CepIntegration cepIntegration;

    @Override
    public EnderecoDTO buscaEnderecoCep( String cep ){

        EnderecoResponse endereco = cepIntegration.buscaEnderecoCep( cep );
        if(endereco == null){
            log.error("endereço está nulo");
            throw new NotFoundException("endereço não encontrado");
        }
        return modelMapper.map( endereco, EnderecoDTO.class ) ;
    }


}
