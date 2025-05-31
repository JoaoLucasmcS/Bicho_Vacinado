package com.BichoVacinado.BichoVacinado.controller;

import com.BichoVacinado.BichoVacinado.dto.request.PetRequest;
import com.BichoVacinado.BichoVacinado.dto.request.VacinaRequest;
import com.BichoVacinado.BichoVacinado.dto.response.PetResponse;
import com.BichoVacinado.BichoVacinado.dto.response.VacinaResponse;
import com.BichoVacinado.BichoVacinado.service.VacinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacinas")
@RequiredArgsConstructor
@Tag(name = "Vacinas", description = "Gerenciamento de vacinas")
public class VacinaController {

    private final VacinaService vacinaService;

    @PostMapping
    @Operation(summary = "Cadastrar uma nova vacina")
    public ResponseEntity<VacinaResponse> cadastrar(@RequestBody @Valid VacinaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vacinaService.cadastrar(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma vacina existente")
    public ResponseEntity<VacinaResponse> atualizar(@PathVariable Long id, @RequestBody @Valid VacinaRequest request) {
        return ResponseEntity.ok(vacinaService.atualizar(id, request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar vacina por ID")
    public ResponseEntity<VacinaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vacinaService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar todas as vacinas")
    public ResponseEntity<List<VacinaResponse>> listarTodos() {
        return ResponseEntity.ok(vacinaService.listarTodos());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar vacina por ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        vacinaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}