package com.BichoVacinado.BichoVacinado.controller;

import com.BichoVacinado.BichoVacinado.dto.request.PetRequest;
import com.BichoVacinado.BichoVacinado.dto.response.PetResponse;
import com.BichoVacinado.BichoVacinado.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
@Tag(name = "Pets", description = "Gerenciamento de pets")
public class PetController {

    private final PetService petService;

    @PostMapping
    @Operation(summary = "Cadastrar um novo pet")
    public ResponseEntity<PetResponse> cadastrar(@RequestBody @Valid PetRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.cadastrar(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um pet existente")
    public ResponseEntity<PetResponse> atualizar(@PathVariable Long id, @RequestBody @Valid PetRequest request) {
        return ResponseEntity.ok(petService.atualizar(id, request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pet por ID")
    public ResponseEntity<PetResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(petService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar todos os pets")
    public ResponseEntity<List<PetResponse>> listarTodos() {
        return ResponseEntity.ok(petService.listarTodos());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar pet por ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        petService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

