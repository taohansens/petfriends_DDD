package org.taohansen.petfriends_transporte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taohansen.petfriends_transporte.entities.Entrega;
import org.taohansen.petfriends_transporte.entities.StatusEntrega;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    List<Entrega> findByStatus(StatusEntrega status);
    List<Entrega> findByPedidoId(Long pedidoId);
    List<Entrega> findByDataRealizacaoEntregaAfter(LocalDate dataPrevisaoEntrega);
}

