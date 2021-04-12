package com.viavarejo.compra;

import com.viavarejo.compra.entidades.Pagto;

public class PagtoBuilder {

	private Pagto pagto;
	private PagtoBuilder(){}

	public static PagtoBuilder umPagto() {
		PagtoBuilder builder = new PagtoBuilder();
		builder.pagto = new Pagto();
		builder.pagto.setValorEntrada(1200.00);
		builder.pagto.setQtdeParcelas(5.0);
		return builder;
	}
	
	
	
	public PagtoBuilder semValorEntrada() {
		pagto.setValorEntrada(0.0);
		return this;
	}
	
	public PagtoBuilder semQtdeParcelas() {
		pagto.setQtdeParcelas(0.0);
		return this;
	}
	
	
	public PagtoBuilder comValorEntrada(Double valor) {
		pagto.setValorEntrada(valor);
		return this;
	}
	
	public PagtoBuilder comQtdeParcelas(Double QtdeParcelas) {
		pagto.setQtdeParcelas(QtdeParcelas);
		return this;
	}
	
	public Pagto agora(){
		return pagto;
	}
	
}
