package com.clickquartos.corecadastroquarto.service;

import com.clickquartos.corecadastroquarto.documento.Morador;
import com.clickquartos.corecadastroquarto.documento.Quarto;
import com.clickquartos.corecadastroquarto.dto.MoradorDTO;
import com.clickquartos.corecadastroquarto.enums.DisponibilidadeEnum;
import com.clickquartos.corecadastroquarto.exception.erros.BadRequestException;
import com.clickquartos.corecadastroquarto.exception.erros.NotFoundException;
import com.clickquartos.corecadastroquarto.repository.QuartoRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MoradorServiceImpl implements MoradorService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CepService cepService;

    @Autowired
    private QuartoRepository quartoRepository;


    @Override
    public MoradorDTO cadastrarMorador( MoradorDTO moradorDTO ) {

        Morador morador = modelMapper.map( moradorDTO, Morador.class );

        String codigoQuarto = moradorDTO.getCodigoQuarto();
        Optional<Quarto> optionalQuarto = quartoRepository.findById( codigoQuarto );

        if (!optionalQuarto.isPresent()) {
            throw new NotFoundException( "Quarto não encontrado" );
        }

        Quarto quarto = optionalQuarto.get();

        if (quarto.getDisponibilidade() == DisponibilidadeEnum.ALUGADO) {
            throw new BadRequestException( "Quarto indisponivel para locação" );
        }


        quarto.setMorador(morador);

        quarto.setDisponibilidade( DisponibilidadeEnum.ALUGADO );

        quartoRepository.save( quarto );
        return modelMapper.map( morador, MoradorDTO.class );

    }


}
