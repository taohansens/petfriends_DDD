package com.taohansen.petfriends_pedido.domain.commandEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarPedidoCommand extends BaseCommand {
    private Long pedidoId;
    private Long clienteId;
    private String clienteNome;
    private Long produtoId;
    private String endereco;

    public CriarPedidoCommand(Long id, Long clienteId, Long produtoId) {
        super(id);
        this.pedidoId = id;
        this.clienteId = clienteId;
        this.produtoId = produtoId;
    }
}
