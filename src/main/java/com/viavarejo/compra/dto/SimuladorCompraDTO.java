package com.viavarejo.compra.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.viavarejo.compra.entidades.Pagto;
import com.viavarejo.compra.entidades.Produto;

public class SimuladorCompraDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;
	private Double valor;
	private Double valorEntrada;
	private Double qtdeParcelas;
	
	
	public SimuladorCompraDTO() {
		
	}
	
    public SimuladorCompraDTO(Produto produto) {
		this.codigo = produto.getCodigo();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
	}
    
    public SimuladorCompraDTO(Pagto pagto) {
		this.valorEntrada = pagto.getValorEntrada();
		this.qtdeParcelas = pagto.getQtdeParcelas();
	}

    
	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(Double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Double getQtdeParcelas() {
		return qtdeParcelas;
	}

	public void setQtdeParcelas(Double qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}

	    
    
    

}
