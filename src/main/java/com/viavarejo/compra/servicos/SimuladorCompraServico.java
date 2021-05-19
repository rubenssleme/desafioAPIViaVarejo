package com.viavarejo.compra.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viavarejo.compra.dto.Parcela;
import com.viavarejo.compra.dto.SimuladorCompraDTO;
import com.viavarejo.compra.entidades.Pagto;
import com.viavarejo.compra.entidades.Produto;
import com.viavarejo.compra.repositorios.PagtoRepositorio;
import com.viavarejo.compra.repositorios.ProdutoRepositorio;

@Service
public class SimuladorCompraServico {
	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@Autowired
	private PagtoRepositorio pagtoRepositorio;
	

	
	
	public Produto insertProduto(Produto obj) {
		return produtoRepositorio.save(obj);
	}

	public Pagto insertPagto(Pagto obj) {
		return pagtoRepositorio.save(obj);
	}
	
	
	public void incluirCompra(SimuladorCompraDTO obj) {
		Produto	produto = insertProduto(new Produto(obj.getNome(),obj.getValor()));
		Pagto pagto = insertPagto(new Pagto(obj.getValorEntrada(),obj.getQtdeParcelas()));
		produto.getPagtos().add(pagto);
	}
	
	public Parcela listaDeParcela(Parcela obj) {
			return obj;
	}
	

}
