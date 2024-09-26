package org.taohansen.petfriends_almoxarifado.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Quantidade {
    private int quantidade;

    public void adicionar(int quantidade) {
        this.quantidade += quantidade;
    }

    public void retirar(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade insuficiente");
        }
    }

}
