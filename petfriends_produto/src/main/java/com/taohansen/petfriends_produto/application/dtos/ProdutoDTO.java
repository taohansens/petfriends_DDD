package com.taohansen.petfriends_produto.application.dtos;

import com.taohansen.petfriends_produto.domain.entitites.Produto;
import lombok.Data;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private double valor;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }
}
