package com.viavarejo.compra.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viavarejo.compra.entidades.Produto;
import com.viavarejo.compra.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repositorio;

	public List<Produto> findAll() {
		return repositorio.findAll();

	}

	public Produto findById(Long id) {
		Optional<Produto> obj = repositorio.findById(id);
		return obj.get();
	}

	public Produto insert(Produto obj) {
		return repositorio.save(obj);
	}
	public void delete(Produto produto) {
        repositorio.delete(produto);
    }

    public Produto update(Produto produto) {
        return repositorio.save(produto);
    }
	
	
}
