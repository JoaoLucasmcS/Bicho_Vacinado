package com.BichoVacinado.BichoVacinado.controller;

import com.BichoVacinado.BichoVacinado.dto.request.PostoDeVacinacaoRequest;
import com.BichoVacinado.BichoVacinado.dto.response.PostoDeVacinacaoResponse;
import com.BichoVacinado.BichoVacinado.service.PostoDeVacinacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postos-de-vacinacao")
@RequiredArgsConstructor
@Tag(name = "Postos de Vacinação", description = "Gerenciamento de postos de vacinação")
public class PostoDeVacinacaoController {

    private final PostoDeVacinacaoService postoDeVacinacaoService;

    @PostMapping
    @Operation(summary = "Cadastrar um novo posto de vacinação")
    public ResponseEntity<PostoDeVacinacaoResponse> cadastrar(@RequestBody @Valid PostoDeVacinacaoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postoDeVacinacaoService.cadastrar(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar posto de vacinação por ID")
    public ResponseEntity<PostoDeVacinacaoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(postoDeVacinacaoService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar todos os postos de vacinação")
    public ResponseEntity<List<PostoDeVacinacaoResponse>> listarTodos() {
        return ResponseEntity.ok(postoDeVacinacaoService.listarTodos());
    }
}