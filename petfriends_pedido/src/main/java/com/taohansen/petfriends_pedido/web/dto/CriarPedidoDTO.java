package com.taohansen.petfriends_pedido.web.dto;

import lombok.Data;

@Data
public class CriarPedidoDTO {
        private Long pedidoId;
        private Long clienteId;
        private String clienteNome;
        private Long produtoId;
        private String endereco;
}
