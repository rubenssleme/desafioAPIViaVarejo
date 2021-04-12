package com.viavarejo.compra.controles;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viavarejo.compra.dto.Parcela;
import com.viavarejo.compra.dto.SimuladorCompraDTO;
import com.viavarejo.compra.entidades.Selic;
import com.viavarejo.compra.entidades.SelicService;
import com.viavarejo.compra.servicos.SimuladorCompraServico;
import com.viavarejo.compra.servicos.TaxaSelicServico;

@RestController
@RequestMapping(value = "/v1/simularCompra")
public class SimuladorCompraControler {
	@Autowired
	private SimuladorCompraServico servico;
	
//	@Autowired
//	private SelicService serviceSelic;
	@Autowired
	private TaxaSelicServico tx;

	@PostMapping
	public ResponseEntity<Parcela> insert(@RequestBody SimuladorCompraDTO obj) {
		servico.incluirCompra(obj);

//		Integer quantidadeDeRegistros = 1;
//		List<Selic> listaTaxaSelic = serviceSelic.buscarTaxaSelic(quantidadeDeRegistros);
//		
	
	
	Parcela parcela = servico.listaDeParcela(new Parcela(1, tx.txSelic()
			,obj.getValor(),obj.getValorEntrada(),obj.getQtdeParcelas()));
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).body(parcela);
	}
	

}
