package com.viavarejo.compra;

import com.viavarejo.compra.entidades.Produto;

public class ProdutoBuilder {

	private Produto produto;
	private ProdutoBuilder(){}

	public static ProdutoBuilder umProduto() {
		ProdutoBuilder builder = new ProdutoBuilder();
		builder.produto = new Produto();
		builder.produto.setCodigo(1L);
		builder.produto.setNome("Chocolate");
		builder.produto.setValor(50.0);
		return builder;
	}
	
	
	
	public ProdutoBuilder semValor() {
		produto.setValor(0.0);
		return this;
	}
	
	
	public ProdutoBuilder comValor(Double valor) {
		produto.setValor(valor);
		return this;
	}
	
	public Produto agora(){
		return produto;
	}
	
}
