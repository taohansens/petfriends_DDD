package com.taohansen.petfriends_pedido.domain.aggregate;

import com.taohansen.petfriends_pedido.domain.commandEvent.CriarPedidoCommand;
import com.taohansen.petfriends_pedido.domain.commandEvent.PedidoCriadoEvent;
import com.taohansen.petfriends_pedido.domain.entities.StatusPedido;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class PedidoAggregate {

    @AggregateIdentifier
    private Long pedidoId;
    private Long produtoId;
    private Long clienteId;
    private String endereco;
    private StatusPedido status;


    @CommandHandler
    public PedidoAggregate(CriarPedidoCommand command) {
        if (command.getClienteId() == null || command.getProdutoId() == null) {
            throw new IllegalArgumentException("Valor Nulo");
        }

        this.pedidoId = command.getPedidoId();
        this.clienteId = command.getClienteId();
        this.produtoId = command.getProdutoId();
        this.status = StatusPedido.CRIADO;
        this.endereco = command.getEndereco();

        apply(new PedidoCriadoEvent(
                command.getPedidoId(),
                command.getClienteId(),
                command.getClienteNome(),
                this.status,
                this.endereco,
                command.getProdutoId()
        ));
    }

    @EventSourcingHandler
    public void on(PedidoCriadoEvent event) {
        this.pedidoId = event.getPedidoId();
        this.clienteId = event.getClienteId();
        this.produtoId = event.getProdutoId();
        this.endereco = event.getEndereco();
        this.status = event.getStatus();
        apply(new PedidoCriadoEvent(this.pedidoId, clienteId,"Cliente Name",StatusPedido.CRIADO, this.endereco, produtoId);
    }
}
