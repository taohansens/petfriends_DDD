package com.taohansen.petfriends_cliente.infrastructure.repositories;

import com.taohansen.petfriends_cliente.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}