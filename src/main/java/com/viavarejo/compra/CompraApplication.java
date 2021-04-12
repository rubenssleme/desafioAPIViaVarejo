package com.viavarejo.compra;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import lombok.extern.slf4j.Slf4j;

@EnableFeignClients
@SpringBootApplication
@Slf4j
public class CompraApplication {
	public static void main(String[] args) {
		SpringApplication.run(CompraApplication.class, args);
	}

}
