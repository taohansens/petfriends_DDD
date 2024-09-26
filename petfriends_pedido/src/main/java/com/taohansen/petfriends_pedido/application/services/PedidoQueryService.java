package com.taohansen.petfriends_pedido.application.services;

import com.taohansen.petfriends_pedido.domain.entities.Pedido;
import com.taohansen.petfriends_pedido.infrastructure.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoQueryService {
    private final EventStore eventStore;
    private final PedidoRepository pedidoRepository;

    public List<Object> listarEventos(Long pedidoId) {
        return eventStore.readEvents(pedidoId.toString()).asStream().collect(Collectors.toList());
    }

    public Optional<Pedido> consultarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }
}
