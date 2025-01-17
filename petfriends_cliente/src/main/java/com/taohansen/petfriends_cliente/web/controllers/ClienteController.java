package com.taohansen.petfriends_cliente.web.controllers;

import com.taohansen.petfriends_cliente.application.dtos.ClienteDTO;
import com.taohansen.petfriends_cliente.application.services.ClienteService;
import com.taohansen.petfriends_cliente.web.controllers.exceptions.StandardError;
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
public class ClienteController {
    final private ClienteService service;

    @Operation(summary = "Retorna uma lista de todos clientes cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista com os empregados cadastrados, vazia ou não", content = {@Content(
                    mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class)))}
            )})
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        List<ClienteDTO> clientes = service.getAll();
        return ResponseEntity.ok().body(clientes);
    }

    @Operation(summary = "Retorna o cliente pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o cliente com o respectivo ID", content = {@Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = ClienteDTO.class)))}),
            @ApiResponse(responseCode = "404", description = "Cliente não localizado", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = StandardError.class))})})
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(
            @Parameter(description = "ID do cliente a ser buscado", required = true)
            @PathVariable Long id) {
        ClienteDTO clienteDTO = service.findById(id);
        return ResponseEntity.ok().body(clienteDTO);
    }

}