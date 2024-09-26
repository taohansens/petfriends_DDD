package org.taohansen.petfriends_almoxarifado.domain.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class RegistrarEstoqueCommand {
    @TargetAggregateIdentifier
    private Long produtoId;
    private int quantidade;
}