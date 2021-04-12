package com.viavarejo.compra;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

import com.viavarejo.compra.entidades.Produto;
import com.viavarejo.compra.servicos.ProdutoServico;

@SpringBootTest
class CompraApplicationTests {
	
	private ProdutoServico servico;

	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	
	@Before
	public void setup(){
		 servico = new ProdutoServico();
	}
	
	@Test
	public void deveRetornarTodosOsProdutos() {
		//cenario
		
		
		//acao
		List<Produto> produtos = servico.findAll();
		
		//verificacao
		//error.checkThat(produtos.);
	}
	
}
