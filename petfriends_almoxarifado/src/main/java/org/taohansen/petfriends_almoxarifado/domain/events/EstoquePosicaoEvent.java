package org.taohansen.petfriends_almoxarifado.domain.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class EstoquePosicaoEvent {
    private Long produtoId;
    private int quantidade;
}
