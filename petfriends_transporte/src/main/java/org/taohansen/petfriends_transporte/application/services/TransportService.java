package org.taohansen.petfriends_transporte.application.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.taohansen.petfriends_transporte.application.PedidoEventDTO;
import org.taohansen.petfriends_transporte.entities.Endereco;
import org.taohansen.petfriends_transporte.entities.Entrega;
import org.taohansen.petfriends_transporte.entities.StatusEntrega;
import org.taohansen.petfriends_transporte.repositories.EntregaRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportService {
    private final EntregaRepository entregaRepository;

        @Transactional
        public void processarPedido(PedidoEventDTO dto) {
            List<Entrega> entregasExistentes = entregaRepository.findByPedidoId(Long.parseLong(dto.getPedidoId()));
            if (entregasExistentes.isEmpty()) {
                Entrega novaEntrega = new Entrega();
                novaEntrega.setPedidoId(Long.parseLong(dto.getPedidoId()));
                Endereco endereco = new Endereco();
                endereco.setRua(dto.getEndereco());
                novaEntrega.setEndereco(endereco);
                novaEntrega.setStatus(StatusEntrega.EM_TRANSPORTE);
                novaEntrega.setDataPrevisaoEntrega(LocalDate.now().plusDays(15));
                entregaRepository.save(novaEntrega);
                System.out.println("Nova entrega criada para o pedido: " + dto.getPedidoId());
            } else {
                for (Entrega entrega : entregasExistentes) {
                    if (entrega.getStatus() == StatusEntrega.PENDENTE) {
                        Endereco endereco = new Endereco();
                        endereco.setRua(dto.getEndereco());
                        entrega.setEndereco(endereco);
                        entrega.setDataRealizacaoEntrega(LocalDate.now());
                        entrega.setStatus(StatusEntrega.ENTREGUE);
                        entregaRepository.save(entrega);
                        System.out.println("Entrega atualizada para o pedido: " + dto.getPedidoId());
                    }
                }
            }
        }
    }
