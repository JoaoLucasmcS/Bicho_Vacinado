package com.BichoVacinado.BichoVacinado.controller;

import com.BichoVacinado.BichoVacinado.model.CartaoDeVacina;
import com.BichoVacinado.BichoVacinado.model.Pet;
import com.BichoVacinado.BichoVacinado.repository.CartaoDeVacinaRepository;
import com.BichoVacinado.BichoVacinado.repository.PetRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cartoes-vacina")
public class CartaoDeVacinaController {

    private final CartaoDeVacinaRepository cartaoRepo;
    private final PetRepository petRepo;

    public CartaoDeVacinaController(CartaoDeVacinaRepository cartaoRepo, PetRepository petRepo) {
        this.cartaoRepo = cartaoRepo;
        this.petRepo = petRepo;
    }

    // Criar ou atualizar cartão de vacina para um pet
    @PostMapping("/pet/{petId}")
    public ResponseEntity<?> criarOuAtualizarCartao(
            @PathVariable Long petId,
            @RequestBody CartaoDeVacina cartao) {

        Optional<Pet> petOptional = petRepo.findById(petId);
        if (petOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Pet não encontrado.");
        }

        Pet pet = petOptional.get();
        cartao.setPet(pet);

        // Se já existir cartão para esse pet, atualiza, senão cria novo
        CartaoDeVacina existente = cartaoRepo.findByPetId(petId);
        if (existente != null) {
            existente.setNome(cartao.getNome());
            // Atualize outros campos se existirem
            cartaoRepo.save(existente);
            return ResponseEntity.ok("Cartão de vacinação atualizado com sucesso.");
        } else {
            cartaoRepo.save(cartao);
            return ResponseEntity.ok("Cartão de vacinação criado com sucesso.");
        }
    }

    // Consultar cartão pelo petId
    @GetMapping("/pet/{petId}")
    public ResponseEntity<?> consultarCartaoPorPet(@PathVariable Long petId) {
        CartaoDeVacina cartao = cartaoRepo.findByPetId(petId);
        if (cartao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartao);
    }
}
