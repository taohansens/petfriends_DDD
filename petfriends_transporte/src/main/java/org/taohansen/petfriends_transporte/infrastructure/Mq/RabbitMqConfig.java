package org.taohansen.petfriends_transporte.infrastructure.Mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    public static final String PEDIDOS_QUEUE = "pedidosQueue";
    public static final String TRANSPORTE_QUEUE = "transportQueue";

    @Bean
    public Queue pedidosQueue() {
        return new Queue(PEDIDOS_QUEUE, true);
    }

    @Bean
    public Queue transportQueue() {
        return new Queue(TRANSPORTE_QUEUE, true);
    }
}



