package com.taohansen.petfriends_produto.web.controllers;

import com.taohansen.petfriends_produto.application.dtos.ProdutoDTO;
import com.taohansen.petfriends_produto.application.services.ProdutoService;
import com.taohansen.petfriends_produto.web.controllers.exceptions.StandardError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ProdutoController {
    final private ProdutoService service;

    @Operation(summary = "Retorna uma lista de todos produtos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista com todos os produtos, vazia ou não", content = {@Content(
                    mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProdutoDTO.class)))}
            )})
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAll() {
        List<ProdutoDTO> produtos = service.getAll();
        return ResponseEntity.ok().body(produtos);
    }

    @Operation(summary = "Retorna o produto pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o produto do ID informado", content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = ProdutoDTO.class)))}),
            @ApiResponse(responseCode = "404", description = "Produto não localizado", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = StandardError.class))})})
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(
            @Parameter(description = "ID do cliente a ser buscado", required = true)
            @PathVariable Long id) {
        ProdutoDTO produtoDTO = service.findByProdutoId(id);
        return ResponseEntity.ok().body(produtoDTO);
    }
}
