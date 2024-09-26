package org.taohansen.petfriends_almoxarifado.domain.events;

import lombok.Data;

@Data
public class PedidoCriadoEvent {
    private Long pedidoId;
    private Long produtoId;
    private int quantidade;
}
