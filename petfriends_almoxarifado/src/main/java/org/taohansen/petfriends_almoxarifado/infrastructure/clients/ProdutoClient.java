package org.taohansen.petfriends_almoxarifado.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.taohansen.petfriends_almoxarifado.infrastructure.dtos.ProdutoDTO;

@FeignClient(name = "petfriends-produto")
public interface ProdutoClient {
    @GetMapping("/api/{produtoId}")
    ProdutoDTO findById(@PathVariable("produtoId") Long produtoId);
}
