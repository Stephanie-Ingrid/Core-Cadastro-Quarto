package com.clickquartos.corecadastroquarto.service;

import com.clickquartos.corecadastroquarto.dto.QuartoDTO;
import com.clickquartos.corecadastroquarto.documento.Quarto;
import com.clickquartos.corecadastroquarto.exception.erros.BadRequestException;
import com.clickquartos.corecadastroquarto.exception.erros.NotFoundException;
import com.clickquartos.corecadastroquarto.repository.QuartoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Data
public class QuartoServiceImpl implements QuartoService{

    private QuartoRepository quartoRepository;

    private ModelMapper modelMapper;

    @Override
    public QuartoDTO createQuarto( QuartoDTO quartoDTO ){

        Quarto quarto = modelMapper.map( quartoDTO, Quarto.class );

        quarto = quartoRepository.save( quarto );

        return modelMapper.map( quarto, QuartoDTO.class );
    }

    @Override
    public List<QuartoDTO> findAll() {

        List<Quarto> quartoList = quartoRepository.findAll();
        Type listType = new TypeToken< ArrayList < QuartoDTO > > () {
        }.getType();

        return modelMapper.map( quartoList, listType );
    }

    @Override
    public void updateQuarto( String codigoQuarto, QuartoDTO quartoDTO ) {
        if ( !codigoQuarto.equalsIgnoreCase( quartoDTO.getCodigoQuarto() )){
            throw new BadRequestException
                    ( "Quarto inexistente, tente novamente ou adicione o codigoQuarto no payload!" );
        }
        verificaQuarto( codigoQuarto );

        Quarto quarto = modelMapper.map( quartoDTO, Quarto.class );

        quartoRepository.save( quarto );
    }

    private Quarto verificaQuarto( String codigoQuarto ){
        Optional<Quarto> optionalQuarto = quartoRepository.findById( codigoQuarto );
        if ( optionalQuarto.isEmpty() ){

            log.warn( "Quarto nao encontrado, quarto: " + codigoQuarto );

            throw new NotFoundException( "Quarto nao encontrado: " + codigoQuarto );
        }

        Quarto quarto = optionalQuarto.get();

        if (quarto.getValor() == null || quarto.getDescricao() == null) {
            log.error("Quarto encontrado com campos nulos: " + quarto.getCodigoQuarto());
            throw new BadRequestException("Quarto encontrado com campos nulos: " + quarto.getCodigoQuarto());
        }

        return quarto;
    }

    @Override
    public void deleteQuarto( String codigoQuarto ) {
        Quarto quarto = verificaQuarto( codigoQuarto );

        quartoRepository.delete( quarto );
    }

}
