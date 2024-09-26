package org.taohansen.petfriends_almoxarifado.application.dtos;

import lombok.Data;
import org.taohansen.petfriends_almoxarifado.domain.entities.Estoque;

@Data
public class EstoqueDTO {
    private Long id;
    private Long produtoId;
    private int quantidade;

    public EstoqueDTO(Estoque estoque) {
        this.id = estoque.getId();
        this.produtoId = estoque.getProdutoId();
        this.quantidade = estoque.getQuantidadeDisponivel().getQuantidade();
    }
}
