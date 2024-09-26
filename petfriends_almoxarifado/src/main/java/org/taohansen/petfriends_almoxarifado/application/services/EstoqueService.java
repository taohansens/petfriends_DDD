package org.taohansen.petfriends_almoxarifado.application.services;


import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.taohansen.petfriends_almoxarifado.application.dtos.EstoqueDTO;
import org.taohansen.petfriends_almoxarifado.application.exceptions.ResourceNotFoundException;
import org.taohansen.petfriends_almoxarifado.domain.entities.Estoque;
import org.taohansen.petfriends_almoxarifado.infrastructure.clients.ProdutoClient;
import org.taohansen.petfriends_almoxarifado.infrastructure.dtos.ProdutoDTO;
import org.taohansen.petfriends_almoxarifado.infrastructure.repositories.EstoqueRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstoqueService {
    private final EstoqueRepository repository;
    private final ProdutoClient produtoClient;

    @Transactional(readOnly = true)
    public List<EstoqueDTO> getAll() {
        List<Estoque> estoque = repository.findAll();
        return estoque.stream()
                .map(EstoqueDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EstoqueDTO findQuantidadeByProdutoId(Long produtoId) {
        ProdutoDTO produtoDTO = getProdutoById(produtoId);
        Optional<Estoque> obj = repository.findByProdutoId(produtoId);
        Estoque entity = obj.orElseThrow(() -> new ResourceNotFoundException(String.format("Produto %d não encontrado no estoque.", produtoId)));
        return new EstoqueDTO(entity);
    }

    public EstoqueDTO saidaEstoque(Long produtoId, int quantidade) {
        ProdutoDTO produtoDTO = getProdutoById(produtoId);
        Optional<Estoque> obj = repository.findByProdutoId(produtoId);
        Estoque entity = obj.orElseThrow(() -> new ResourceNotFoundException(String.format("Produto %d não encontrado no estoque.", produtoId)));
        entity.getQuantidadeDisponivel().retirar(quantidade);
        entity = repository.save(entity);
        return new EstoqueDTO(entity);
    }

    public EstoqueDTO entradaEstoque(Long produtoId, int quantidade) {
        ProdutoDTO produtoDTO = getProdutoById(produtoId);
        Optional<Estoque> obj = repository.findByProdutoId(produtoId);
        Estoque entity = obj.orElseThrow(() -> new ResourceNotFoundException(String.format("Produto %d não encontrado no estoque.", produtoId)));
        entity.getQuantidadeDisponivel().adicionar(quantidade);
        entity = repository.save(entity);
        return new EstoqueDTO(entity);
    }

    private ProdutoDTO getProdutoById(Long id) {
        try {
            return produtoClient.findById(id);
        } catch (FeignException.FeignClientException.NotFound e) {
            throw new ResourceNotFoundException("Produto com ID " + id + " não encontrado");
        }

    }
}
