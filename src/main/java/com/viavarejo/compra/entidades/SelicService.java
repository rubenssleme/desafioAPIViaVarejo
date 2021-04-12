package com.viavarejo.compra.entidades;



import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "SelicService", url="https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados/ultimos/")
public interface SelicService {
    @GetMapping("{qtd}?formato=json")
    List<Selic> buscarTaxaSelic(@PathVariable("qtd") Integer quantidade);

	//BigDecimal txSelic();
    
    
   
}
