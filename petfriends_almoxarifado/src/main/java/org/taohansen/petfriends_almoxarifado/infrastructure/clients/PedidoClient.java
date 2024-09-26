package org.taohansen.petfriends_almoxarifado.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.taohansen.petfriends_almoxarifado.infrastructure.dtos.PedidoDTO;

@FeignClient(name = "petfriends-pedido")
public interface PedidoClient {

    @GetMapping("/api/{pedidoId}")
    PedidoDTO findById(@PathVariable("pedidoId") Long pedidoId);
}

