package com.taohansen.petfriends_produto.domain.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoCreatedEvent {
    private Long produtoId;
    private String eventType;
}