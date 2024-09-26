package com.taohansen.petfriends_pedido.infrastructure.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String endereco;
}
