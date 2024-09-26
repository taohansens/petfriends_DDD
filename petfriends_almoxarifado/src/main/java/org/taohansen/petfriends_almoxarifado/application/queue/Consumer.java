package org.taohansen.petfriends_almoxarifado.application.queue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.taohansen.petfriends_almoxarifado.application.services.EstoqueService;
import org.taohansen.petfriends_almoxarifado.infrastructure.Mq.RabbitMqConfig;

@Service
@RequiredArgsConstructor
public class Consumer {
    private final EstoqueService estoqueService;

    @RabbitListener(queues = RabbitMqConfig.PEDIDOS_QUEUE)
    public void handlePedidos(PedidoEventDTO dto) {
        System.out.println("Received pedido: " + dto);
        estoqueService.saidaEstoque(Long.valueOf(dto.getPedidoId()), Integer.parseInt(dto.getQtd()));
    }
}

