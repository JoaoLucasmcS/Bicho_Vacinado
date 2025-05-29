package com.BichoVacinado.BichoVacinado.controller;

import com.BichoVacinado.BichoVacinado.dto.request.CartaoDeVacinaRequest;
import com.BichoVacinado.BichoVacinado.dto.response.CartaoDeVacinaResponse;
import com.BichoVacinado.BichoVacinado.service.CartaoDeVacinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cartoes-de-vacina")
@RequiredArgsConstructor
@Tag(name = "Cartões de Vacina", description = "Gerenciamento de cartões de vacina")
public class CartaoDeVacinaController {

    private final CartaoDeVacinaService cartaoDeVacinaService;

    @PostMapping
    @Operation(summary = "Cadastrar um novo cartão de vacina")
    public ResponseEntity<CartaoDeVacinaResponse> cadastrar(@RequestBody @Valid CartaoDeVacinaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoDeVacinaService.cadastrar(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cartão de vacina por ID")
    public ResponseEntity<CartaoDeVacinaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cartaoDeVacinaService.buscarPorId(id));
    }

    @GetMapping("/pet/{id}")
    @Operation(summary = "Buscar cartão de vacina por Pet Id")
    public ResponseEntity<CartaoDeVacinaResponse> buscarPorPetId(@PathVariable Long id) {
        return ResponseEntity.ok(cartaoDeVacinaService.buscarPorPetId(id));
    }
}