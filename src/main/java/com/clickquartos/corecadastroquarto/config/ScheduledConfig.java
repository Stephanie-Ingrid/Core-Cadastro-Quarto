package com.clickquartos.corecadastroquarto.config;

import com.clickquartos.corecadastroquarto.service.ScheduledService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@Slf4j
@Data
public class ScheduledConfig {

    private ScheduledService scheduledService;


//    @Scheduled(cron = "0 * * ? * *") *Teste
    @Scheduled( cron = "0 0 8 ? * TUE" )
    private void disparoFaxina (){

        log.info("iniciou disparo faxina");

        scheduledService.schedulerFaxina();

        log.info("terminou disparo faxina");
    }

//    @Scheduled(cron = "0 * * ? * *") *Teste
    @Scheduled(cron = "0 0 0 25 12 ?")
    private void disparoEmailNatal (){
        log.info("iniciou disparo Natal");

        scheduledService.schedulerNatal();

        log.info("terminou disparo Natal");
    }



}
