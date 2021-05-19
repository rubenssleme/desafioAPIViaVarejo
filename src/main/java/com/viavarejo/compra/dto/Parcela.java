package com.viavarejo.compra.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Parcela implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int numero;
	private Double valor;
	private BigDecimal taxaDeJurosAoMes;
	
	public Parcela() {
		
	}
	public Parcela(int numero, BigDecimal taxaDeJurosAoMes,Double valorProduto,Double valorEntrada,Double qtdeParcelas) {
		super();
		this.numero = numero;
		this.valor = valorParcela(qtdeParcelas,valorEntrada,valorProduto);
		this.taxaDeJurosAoMes = taxaDeJurosAoMes;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public BigDecimal getTaxaDeJurosAoMes() {
		return taxaDeJurosAoMes;
	}
	public void setTaxaDeJurosAoMes(BigDecimal taxaDeJurosAoMes) {
		this.taxaDeJurosAoMes = taxaDeJurosAoMes;
	}
	
	public Double valorParcela(Double qtdeParcela, Double valorEntrada, Double valorProduto ) {
		return ((valorProduto - valorEntrada)/qtdeParcela);
	}
	
	
}
