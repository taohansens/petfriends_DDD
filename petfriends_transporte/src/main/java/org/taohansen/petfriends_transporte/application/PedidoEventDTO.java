package org.taohansen.petfriends_transporte.application;

import lombok.Data;

@Data
public class PedidoEventDTO {
    private String pedidoId;
    private String clienteId;
    private String endereco;
    private String produtoId;
}
