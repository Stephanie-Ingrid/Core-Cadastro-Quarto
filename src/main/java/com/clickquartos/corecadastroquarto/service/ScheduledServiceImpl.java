package com.clickquartos.corecadastroquarto.service;

import com.clickquartos.corecadastroquarto.documento.Morador;
import com.clickquartos.corecadastroquarto.documento.Quarto;
import com.clickquartos.corecadastroquarto.integration.DisparoIntegration;
import com.clickquartos.corecadastroquarto.integration.model.DisparoEmailRequest;
import com.clickquartos.corecadastroquarto.integration.model.DisparoEmailResponse;
import com.clickquartos.corecadastroquarto.repository.QuartoRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Data
public class ScheduledServiceImpl implements ScheduledService {

    private QuartoRepository quartoRepository;

    private DisparoIntegration disparoIntegration;

    @Override
    public void schedulerFaxina() {

        List<Quarto> quartoList = quartoRepository.findAll();

        for (Quarto quarto : quartoList) {
            Morador morador = quarto.getMorador();

            if (isMoradorValido(morador)) {

                disparoEmailFaxina(morador.getEmail(), morador.getNomeCompleto());

                log.info("Email faxina : " + quarto.getCodigoQuarto());
            }
        }
    }

    private boolean isMoradorValido(Morador morador) {
        return morador != null && !morador.getEmail().isBlank();
    }

    @Override
    public void schedulerNatal() {

        List<Quarto> quartoList = quartoRepository.findAll();

        for (Quarto quarto : quartoList) {
            Morador morador = quarto.getMorador();

            if (isMoradorValido(morador)) {

                disparoEmailNatal(morador.getEmail(), morador.getNomeCompleto());
                log.info("Email Natal enviado: " + quarto.getCodigoQuarto());

            }
        }
    }


    private void disparoEmailNatal(String email, String nomeMorador) {

        DisparoEmailRequest novoDisparo = DisparoEmailRequest
                .builder()
                .destinatario(email)
                .assunto("Feliz Natal " + nomeMorador + "\uD83C\uDF85")
                .corpo(" Nós da equipe ClickQuartos desejamos um Feliz Natal e um próspero Ano Novo!" +
                        " Que suas comemorações sejam incríveis e repletas de alegria." +
                        " Somos privilegiados em ter você como nosso morador," +
                        " e que no próximo ano possamos continuar com essa parceria incrível! Boas Festas!\n" +
                        "\n" +
                        "Abraços,\n" +
                        "\n" +
                        "Equipe ClickQuartos")
                .build();

        DisparoEmailResponse disparoEmail = disparoIntegration.disparoEmail((novoDisparo));

    }


    private void disparoEmailFaxina(String email, String nomeMorador) {

        DisparoEmailRequest novoDisparo = DisparoEmailRequest
                .builder()
                .destinatario(email)
                .assunto("Hoje é dia de faxina \uD83E\uDDF9")
                .corpo("Bom dia " + nomeMorador + "/n" +
                        " Passando aqui só para Lembrar que hoje teremos faxina no apartamento, a faxina inclui a limpeza do quarto. " +
                        " Se quiser que a faxina seja feita em seu quarto, basta deixar a porta destrancada que nossa Colaboradora entrará e fará a limpeza." +
                        " Caso não basta deixar a porta trancada" +
                        "\n" +
                        "Atenciosamente,\n" +
                        "\n" +
                        "Equipe ClickQuartos")
                .build();

        DisparoEmailResponse disparoEmail = disparoIntegration.disparoEmail((novoDisparo));

    }
}
