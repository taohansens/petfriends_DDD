package com.taohansen.petfriends_cliente.domain.entities;

import com.taohansen.petfriends_cliente.domain.valueobjects.Endereco;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;
}