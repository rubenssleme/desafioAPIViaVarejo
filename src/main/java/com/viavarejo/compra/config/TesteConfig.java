package com.viavarejo.compra.config;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.viavarejo.compra.entidades.Pagto;
import com.viavarejo.compra.entidades.Produto;
import com.viavarejo.compra.repositorios.PagtoRepositorio;
import com.viavarejo.compra.repositorios.ProdutoRepositorio;


@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private PagtoRepositorio pagtoRepositorio;

	@Override
	public void run(String... args) throws Exception {

		Pagto pag1 = new Pagto(30.5,5.0);
		Pagto pag2 = new Pagto(30.5,5.0);
		Pagto pag3 = new Pagto(30.5,5.0);
		Pagto pag4 = new Pagto(30.5,5.0);
		pagtoRepositorio.saveAll(Arrays.asList(pag1, pag2, pag3, pag4));

		Produto p1 = new Produto(null, "The Lord of the Rings",90.5);
		Produto p2 = new Produto(null, "Smart TV",  2190.0);
		Produto p3 = new Produto(null, "Macbook Pro",  1250.0);
		Produto p4 = new Produto(null, "PC Gamer",  1200.0);
		Produto p5 = new Produto(null, "Rails for Dummies",100.99);
		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		
		  p1.getPagtos().add(pag1); 
		  p2.getPagtos().add(pag2);
		  p2.getPagtos().add(pag1); 
		  p3.getPagtos().add(pag3);
		  p4.getPagtos().add(pag4); 
		  p5.getPagtos().add(pag2);
		  produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		 
		
		
	}
}
