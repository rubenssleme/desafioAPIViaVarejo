package com.viavarejo.compra.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viavarejo.compra.entidades.Pagto;
import com.viavarejo.compra.repositorios.PagtoRepositorio;
@Service
public class PagtoServico {

	@Autowired
	private PagtoRepositorio repositorio;

	public List<Pagto> findAll() {
		return repositorio.findAll();

	}

	public Pagto findById(Long id) {
		Optional<Pagto> obj = repositorio.findById(id);
		return obj.get();
	}

	public Pagto insert(Pagto obj) {
		return repositorio.save(obj);
	}
}
