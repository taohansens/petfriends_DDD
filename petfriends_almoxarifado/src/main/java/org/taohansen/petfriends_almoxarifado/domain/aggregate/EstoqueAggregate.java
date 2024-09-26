package org.taohansen.petfriends_almoxarifado.domain.aggregate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.taohansen.petfriends_almoxarifado.domain.commands.RegistrarEstoqueCommand;
import org.taohansen.petfriends_almoxarifado.domain.events.EstoquePosicaoEvent;
import org.taohansen.petfriends_almoxarifado.domain.valueObjects.Quantidade;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@Entity @Data
@Builder @AllArgsConstructor @NoArgsConstructor
public class EstoqueAggregate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @AggregateIdentifier
    private Long id;

    @Embedded
    private Quantidade quantidade;

    @CommandHandler
    public EstoqueAggregate(RegistrarEstoqueCommand command) {
        apply(new EstoquePosicaoEvent(command.getProdutoId(), command.getQuantidade()));
    }

    @EventSourcingHandler
    public void on(EstoquePosicaoEvent event) {
        this.id = event.getProdutoId();
        this.quantidade.retirar(event.getQuantidade());
    }
}
