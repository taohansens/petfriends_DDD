package com.taohansen.petfriends_pedido.infrastructure.repositories;

import com.taohansen.petfriends_pedido.domain.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
