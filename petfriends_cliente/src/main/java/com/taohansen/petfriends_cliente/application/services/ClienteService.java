package com.taohansen.petfriends_cliente.application.services;

import com.taohansen.petfriends_cliente.application.dtos.ClienteDTO;
import com.taohansen.petfriends_cliente.application.exceptions.ResourceNotFoundException;
import com.taohansen.petfriends_cliente.domain.entities.Cliente;
import com.taohansen.petfriends_cliente.infrastructure.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    @Transactional(readOnly = true)
    public List<ClienteDTO> getAll() {
        List<Cliente> clientes = repository.findAll();
        return clientes.stream()
                .map(ClienteDTO::new)
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        Cliente entity = obj.orElseThrow(() -> new ResourceNotFoundException(String.format("Cliente %d não encontrado.", id)));
        return new ClienteDTO(entity);
    }
}
