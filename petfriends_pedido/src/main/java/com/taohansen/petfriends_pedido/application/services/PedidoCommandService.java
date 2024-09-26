package com.taohansen.petfriends_pedido.application.services;

import com.taohansen.petfriends_pedido.domain.commandEvent.CriarPedidoCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoCommandService {
    private final CommandGateway commandGateway;

    public void criarPedido(Long pedidoId, Long clienteId, Long produtoId) {
        CriarPedidoCommand command = new CriarPedidoCommand(pedidoId, clienteId, produtoId);
        commandGateway.send(command);
    }
}