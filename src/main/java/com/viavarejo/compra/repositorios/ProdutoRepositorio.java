package com.viavarejo.compra.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viavarejo.compra.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{

}
