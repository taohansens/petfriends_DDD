package com.taohansen.petfriends_produto.application.services;


import com.taohansen.petfriends_produto.application.dtos.ProdutoDTO;
import com.taohansen.petfriends_produto.application.exceptions.ResourceNotFoundException;
import com.taohansen.petfriends_produto.domain.entitites.Produto;
import com.taohansen.petfriends_produto.infrastructure.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository repository;

    @Transactional(readOnly = true)
    public List<ProdutoDTO> getAll() {
        List<Produto> estoque = repository.findAll();
        return estoque.stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProdutoDTO findByProdutoId(Long produtoId) {
        Optional<Produto> obj = repository.findById(produtoId);
        Produto entity = obj.orElseThrow(() -> new ResourceNotFoundException(String.format("Produto %d não encontrado.", produtoId)));
        return new ProdutoDTO(entity);
    }
}
