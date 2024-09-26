package com.taohansen.petfriends_pedido.domain.entities;

import com.taohansen.petfriends_pedido.domain.valueobjects.Endereco;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clientId;
    private Long productId;
    private StatusPedido status;
    @Embedded
    private Endereco endereco;

    private String formatarEndereco() {
        if (endereco == null || endereco.getRua() == null || endereco.getCidade() == null || endereco.getEstado() == null || endereco.getCep() == null) {
            throw new IllegalArgumentException("Endereço inválido.");
        }
        return endereco.getRua() + ", " + endereco.getCidade() + ", " + endereco.getEstado() + " - " + endereco.getCep();
    }
}
