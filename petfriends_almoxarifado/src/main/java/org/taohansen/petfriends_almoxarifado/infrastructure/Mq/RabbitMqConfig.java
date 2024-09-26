package org.taohansen.petfriends_almoxarifado.infrastructure.Mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    public static final String PEDIDOS_QUEUE = "pedidosQueue";
    public static final String ALMOXERIFADO_QUEUE = "almoxarifadoQueue";

    @Bean
    public Queue logQueue() {
        return new Queue(PEDIDOS_QUEUE, true);
    }

    @Bean
    public Queue auditQueue() {
        return new Queue(ALMOXERIFADO_QUEUE, true);
    }
}



