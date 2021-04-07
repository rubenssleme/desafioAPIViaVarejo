package com.viavarejo.compra.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viavarejo.compra.entidades.Pagto;

public interface PagtoRepositorio extends JpaRepository<Pagto, Long> {
}
