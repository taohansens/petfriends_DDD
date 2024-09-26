package com.taohansen.petfriends_pedido.domain.commandEvent;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@RequiredArgsConstructor
@Data
public class BaseCommand {
    @TargetAggregateIdentifier
    private final Long id;
}