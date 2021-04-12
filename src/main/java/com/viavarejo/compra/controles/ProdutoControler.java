package com.viavarejo.compra.controles;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viavarejo.compra.entidades.Produto;
import com.viavarejo.compra.servicos.ProdutoServico;

@RestController
@RequestMapping(value = "/v1/produtos")
public class ProdutoControler {

	@Autowired
	private ProdutoServico servico;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Produto> insert(@RequestBody Produto obj) {
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
