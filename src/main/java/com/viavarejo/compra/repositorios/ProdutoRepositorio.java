package com.viavarejo.compra.repositorios;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viavarejo.compra.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{
	
	public Optional<Produto> findById(Long id);
}
