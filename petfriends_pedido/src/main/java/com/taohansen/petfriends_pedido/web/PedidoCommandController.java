package com.taohansen.petfriends_pedido.web;

import com.taohansen.petfriends_pedido.application.services.PedidoCommandService;
import com.taohansen.petfriends_pedido.web.dto.CriarPedidoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoCommandController {
    private final PedidoCommandService pedidoCommandService;

    @PostMapping
    public ResponseEntity<String> criarPedido(@RequestBody CriarPedidoDTO request) {
        pedidoCommandService.criarPedido(request.getPedidoId(), request.getClienteId(), request.getProdutoId());
        return ResponseEntity.ok("Pedido criado com sucesso");
    }
}