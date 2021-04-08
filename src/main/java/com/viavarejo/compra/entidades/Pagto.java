package com.viavarejo.compra.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tb_pagto")
public class Pagto implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double valorEntrada;
	private Double qtdeParcelas;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "pagtos")
	private Set<Produto> produtos = new HashSet<>();
	
	public Pagto() {
		
	}
	

	public Pagto(Double valorEntrada, Double qtdeParcelas) {
		super();
		this.valorEntrada = valorEntrada;
		this.qtdeParcelas = qtdeParcelas;
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
