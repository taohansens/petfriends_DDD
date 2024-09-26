package com.taohansen.petfriends_pedido.domain.commandEvent;

import com.taohansen.petfriends_pedido.domain.entities.StatusPedido;
import lombok.*;

@Getter @Setter
public class PedidoCriadoEvent extends BaseEvent<Long>{
    private Long pedidoId;
    private Long clienteId;
    private String clienteNome;
    private StatusPedido status;
    private String endereco;
    private Long produtoId;

    public PedidoCriadoEvent(Long id, Long clientId, String clienteNome, StatusPedido status, String endereco, Long produtoId) {
        super(id);
        this.clienteId = clientId;
        this.clienteNome = clienteNome;
        this.status = status;
        this.endereco = endereco;
        this.produtoId = produtoId;
    }

}

