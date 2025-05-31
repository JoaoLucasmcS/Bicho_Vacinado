package com.BichoVacinado.BichoVacinado.controller;

import com.BichoVacinado.BichoVacinado.dto.request.VacinaRequest;
import com.BichoVacinado.BichoVacinado.dto.request.VacinacaoRequest;
import com.BichoVacinado.BichoVacinado.dto.response.VacinaResponse;
import com.BichoVacinado.BichoVacinado.dto.response.VacinacaoResponse;
import com.BichoVacinado.BichoVacinado.service.VacinacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vacinacoes")
@RequiredArgsConstructor
@Tag(name = "Vacinações", description = "Gerenciamento de vacinações")
public class VacinacaoController {

    private final VacinacaoService vacinacaoService;

    @PostMapping
    @Operation(summary = "Cadastrar uma nova vacinação")
    public ResponseEntity<VacinacaoResponse> cadastrar(@RequestBody @Valid VacinacaoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vacinacaoService.cadastrar(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma vacinação existente")
    public ResponseEntity<VacinacaoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid VacinacaoRequest request) {
        return ResponseEntity.ok(vacinacaoService.atualizar(id, request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar vacinação por ID")
    public ResponseEntity<VacinacaoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vacinacaoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar vacinação por ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        vacinacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}