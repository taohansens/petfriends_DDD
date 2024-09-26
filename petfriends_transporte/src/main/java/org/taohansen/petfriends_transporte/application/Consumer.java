package org.taohansen.petfriends_transporte.application;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.taohansen.petfriends_transporte.application.services.TransportService;
import org.taohansen.petfriends_transporte.infrastructure.Mq.RabbitMqConfig;

@Service
@RequiredArgsConstructor
public class Consumer {
    private final TransportService service;

    @RabbitListener(queues = RabbitMqConfig.PEDIDOS_QUEUE)
    public void handlePedidos(PedidoEventDTO dto) {
        System.out.println("Received pedido: " + dto);
        service.processarPedido(dto);
    }
}

