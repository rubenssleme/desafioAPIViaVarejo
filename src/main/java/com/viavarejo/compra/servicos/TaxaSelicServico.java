package com.viavarejo.compra.servicos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viavarejo.compra.entidades.Selic;
import com.viavarejo.compra.entidades.SelicService;

@Service
public class TaxaSelicServico {

	@Autowired
	private SelicService serviceSelic;
	
	public  BigDecimal txSelic() {
		BigDecimal TaxaSelic;
		Integer quantidadeDeRegistros = 1;
		List<Selic> listaTaxaSelic = serviceSelic.buscarTaxaSelic(quantidadeDeRegistros);

		if (listaTaxaSelic.isEmpty()) {
			TaxaSelic = new BigDecimal("999");
		} else {
			TaxaSelic = listaTaxaSelic.get(0).getValor();
		}
		return TaxaSelic;
	}
}
