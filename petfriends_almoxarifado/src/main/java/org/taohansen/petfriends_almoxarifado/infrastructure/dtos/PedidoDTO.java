package org.taohansen.petfriends_almoxarifado.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long pedidoId;
    private Long clienteId;
    private Long produtoId;
    private int quantidade;
}
