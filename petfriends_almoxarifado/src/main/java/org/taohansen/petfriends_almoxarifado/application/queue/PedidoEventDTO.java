package org.taohansen.petfriends_almoxarifado.application.queue;

import lombok.Data;

@Data
public class PedidoEventDTO {
    private String pedidoId;
    private String clienteId;
    private String qtd;
    private String produtoId;
}
