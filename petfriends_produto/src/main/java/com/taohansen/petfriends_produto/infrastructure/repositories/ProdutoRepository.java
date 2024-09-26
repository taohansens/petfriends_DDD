package com.taohansen.petfriends_produto.infrastructure.repositories;

import com.taohansen.petfriends_produto.domain.entitites.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
