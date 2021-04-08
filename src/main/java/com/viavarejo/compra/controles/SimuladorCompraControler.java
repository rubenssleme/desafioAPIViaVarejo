package com.viavarejo.compra.controles;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viavarejo.compra.dto.SimuladorCompraDTO;
import com.viavarejo.compra.entidades.Pagto;
import com.viavarejo.compra.entidades.Produto;
import com.viavarejo.compra.servicos.SimuladorCompraServico;

@RestController
@RequestMapping(value = "/v1/simularCompra")
public class SimuladorCompraControler {
	@Autowired
	private SimuladorCompraServico servico;

	@PostMapping
	public ResponseEntity<SimuladorCompraDTO> insert(@RequestBody SimuladorCompraDTO obj) {
	Produto	produto = servico.insertProduto(new Produto(obj.getNome(),obj.getValor()));
	Pagto pagto = servico.insertPagto(new Pagto(obj.getValorEntrada(),obj.getQtdeParcelas()));
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
