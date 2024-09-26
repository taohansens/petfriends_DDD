package org.taohansen.petfriends_almoxarifado.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.taohansen.petfriends_almoxarifado.application.dtos.EstoqueDTO;
import org.taohansen.petfriends_almoxarifado.application.services.EstoqueService;
import org.taohansen.petfriends_almoxarifado.web.exceptions.StandardError;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class EstoqueController {
    final private EstoqueService service;

    @Operation(summary = "Retorna uma lista de todos os estoques cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista com os estoques cadastrados, vazia ou não", content = {@Content(
                    mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = EstoqueDTO.class)))}
            )})
    @GetMapping
    public ResponseEntity<List<EstoqueDTO>> getAll() {
        List<EstoqueDTO> clientes = service.getAll();
        return ResponseEntity.ok().body(clientes);
    }

    @Operation(summary = "Retorna o cliente pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o Estoque do respectivo ID do produto", content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = EstoqueDTO.class)))}),
            @ApiResponse(responseCode = "404", description = "Produto não localizado", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = StandardError.class))})})
    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<EstoqueDTO> buscarPorProdutoId(
            @Parameter(description = "ID do produto a ser buscado no estoque", required = true)
            @PathVariable Long produtoId) {
        EstoqueDTO estoqueDTO = service.findQuantidadeByProdutoId(produtoId);
        return ResponseEntity.ok().body(estoqueDTO);
    }


    @Operation(summary = "Adiciona itens no estoque do produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o Estoque do respectivo ID do produto após adição", content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = EstoqueDTO.class)))}),
            @ApiResponse(responseCode = "404", description = "Produto não localizado", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = StandardError.class))})})
    @PutMapping("/produto/{produtoId}/entrada")
    public ResponseEntity<EstoqueDTO> entradaEstoque(
            @Parameter(description = "ID do produto a ser buscado no estoque", required = true)
            @PathVariable Long produtoId,
            @Parameter(description = "Quantidade a ser adicionada no estoque", required = true)
            @RequestParam int quantidade) {
        EstoqueDTO estoqueDTO = service.entradaEstoque(produtoId, quantidade);
        return ResponseEntity.ok().body(estoqueDTO);
    }

    @Operation(summary = "Retira itens no estoque do produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o Estoque do respectivo ID do produto após remoção", content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = EstoqueDTO.class)))}),
            @ApiResponse(responseCode = "404", description = "Produto não localizado", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = StandardError.class))})})
    @PutMapping("/produto/{produtoId}/saida")
    public ResponseEntity<EstoqueDTO> saidaEstoque(
            @Parameter(description = "ID do produto a ser buscado no estoque", required = true)
            @PathVariable Long produtoId,
            @Parameter(description = "Quantidade a ser removida no estoque", required = true)
            @RequestParam int quantidade) {
        EstoqueDTO estoqueDTO = service.saidaEstoque(produtoId, quantidade);
        return ResponseEntity.ok().body(estoqueDTO);
    }

}