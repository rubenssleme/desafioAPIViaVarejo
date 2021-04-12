package com.viavarejo.compra.controles;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viavarejo.compra.entidades.Produto;
import com.viavarejo.compra.servicos.ProdutoServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "API REST Compra Via Varejo")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/v1/produtos")
public class ProdutoControler {

	@Autowired
	private ProdutoServico servico;

	@GetMapping
	@ApiOperation(value = "Retorna uma lista de produtos")
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Retorna um produto unico")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	@ApiOperation(value = "Inclui um produto")
	public ResponseEntity<Produto> insert(@RequestBody Produto obj) {
		obj = servico.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping("/produto")
	@ApiOperation(value = "Deletar um produto")
	public void deletarProduto(@RequestBody Produto produto) {
		servico.delete(produto);
	}

	@PutMapping("/produto")
	@ApiOperation(value = "Atualizar um produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return servico.update(produto);
	}
}
