package com.viavarejo.compra;

import static com.viavarejo.compra.ProdutoBuilder.umProduto;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.viavarejo.compra.entidades.Pagto;
import com.viavarejo.compra.entidades.Produto;
import com.viavarejo.compra.repositorios.PagtoRepositorio;
import com.viavarejo.compra.repositorios.ProdutoRepositorio;
import com.viavarejo.compra.servicos.PagtoServico;
import com.viavarejo.compra.servicos.ProdutoServico;



@SpringBootTest
class CompraApplicationTests {
	@InjectMocks
	private ProdutoServico servico;
	@InjectMocks
	private PagtoServico pagtoServico;
	@Mock
	ProdutoRepositorio repositorio;
	@Mock
	private PagtoRepositorio pagtoRepositorio;
	

	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveRetornarProdutos() {
		List<Produto>produtos = servico.findAll();
		Mockito.when(servico.findAll()).thenReturn(produtos);
		
	}
	@Test
	public void deveInserirUmProduto() {
		Produto produto = umProduto().agora();
		Mockito.when(servico.insert(produto)).thenReturn(produto);
	}
	
	@Test
	public void deveRetornarPagto() {
		List<Pagto>Pagtos = pagtoServico.findAll();
		Mockito.when(pagtoServico.findAll()).thenReturn(Pagtos);
		
	}
	@Test
	public void deveInserirUmPagto() {
		Pagto Pagto = PagtoBuilder.umPagto().agora();
		Mockito.when(pagtoServico.insert(Pagto)).thenReturn(Pagto);
	}
	
}
