package com.viavarejo.compra;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.viavarejo.compra.entidades.Selic;
import com.viavarejo.compra.entidades.SelicService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@EnableFeignClients
@SpringBootApplication
@Slf4j
public class CompraApplication {
	private static final Logger log = LoggerFactory.getLogger(CompraApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CompraApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(SelicService serviceSelic) {
		return args -> {
			if (args.length > 0) {
				Integer quantidadeDeRegistros = 1;
				List<Selic> listaTaxaSelic = serviceSelic.buscarTaxaSelic(quantidadeDeRegistros);
				log.info("Quantidade de retornos {}", quantidadeDeRegistros);
				log.info("Lista da Taxa Selic {}", listaTaxaSelic);
			}
		};
	}
}
