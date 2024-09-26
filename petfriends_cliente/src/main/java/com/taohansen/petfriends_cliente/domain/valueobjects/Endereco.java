package com.taohansen.petfriends_cliente.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Endereco {
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    @Override
    public String toString() {
        return rua + ", " + numero + " - " + complemento + " - " + bairro +
                ", " + cidade + '/' + estado + ", " + cep + ".";
    }
}
