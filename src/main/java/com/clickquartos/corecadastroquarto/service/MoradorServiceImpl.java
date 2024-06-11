package com.clickquartos.corecadastroquarto.service;

import com.clickquartos.corecadastroquarto.documento.Morador;
import com.clickquartos.corecadastroquarto.documento.Quarto;
import com.clickquartos.corecadastroquarto.dto.MoradorDTO;
import com.clickquartos.corecadastroquarto.enums.DisponibilidadeEnum;
import com.clickquartos.corecadastroquarto.exception.erros.BadRequestException;
import com.clickquartos.corecadastroquarto.exception.erros.NotFoundException;
import com.clickquartos.corecadastroquarto.integration.DisparoIntegration;
import com.clickquartos.corecadastroquarto.integration.model.DisparoEmailRequest;
import com.clickquartos.corecadastroquarto.integration.model.DisparoEmailResponse;
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

    @Autowired
    private DisparoIntegration disparoIntegration;


    @Override
    public MoradorDTO cadastrarMorador( MoradorDTO moradorDTO ) {

        Morador morador = modelMapper.map( moradorDTO, Morador.class );

        Quarto quarto = verificaQuarto( moradorDTO.getCodigoQuarto() );

        quarto.setMorador( morador );

        quarto.setDisponibilidade( DisponibilidadeEnum.ALUGADO );

        quartoRepository.save( quarto );

        sendEmail( morador.getEmail(), morador.getNomeCompleto() );

        return modelMapper.map( morador, MoradorDTO.class );

    }

    private Quarto verificaQuarto(String codigoQuarto) {

        Optional<Quarto> optionalQuarto = quartoRepository.findById( codigoQuarto );

        if (!optionalQuarto.isPresent()) {
            throw new NotFoundException( "Quarto não encontrado" );
        }

        Quarto quarto = optionalQuarto.get();

        if (quarto.getDisponibilidade() == DisponibilidadeEnum.ALUGADO) {
            throw new BadRequestException( "Quarto indisponivel para locação" );
        }
        return quarto;
    }

    private void sendEmail(String email, String nomeMorador) {

        DisparoEmailRequest novoDisparo = DisparoEmailRequest
                .builder()
                .destinatario(email)
                .assunto("Seja bem vindo(a) " + nomeMorador)
                .corpo("Seja bem-vindo a nossa plataforma ClickQuartos, saiba que temos a melhor plataforma de locações de quartos." +
                        " Pode contar conosco para o que precisar!!!\n" +
                        "\n" +
                        "Abraços,\n" +
                        "\n" +
                        "Equipe ClickQuartos")
                .build();

        DisparoEmailResponse disparoEmail = disparoIntegration.disparoEmail(novoDisparo);


    }
}