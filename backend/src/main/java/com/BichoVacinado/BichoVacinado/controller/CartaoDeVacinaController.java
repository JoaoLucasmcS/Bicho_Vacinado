package com.BichoVacinado.BichoVacinado.controller;

import com.BichoVacinado.BichoVacinado.model.CartaoDeVacina;
import com.BichoVacinado.BichoVacinado.model.Pet;
import com.BichoVacinado.BichoVacinado.model.Vacina;
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

    // Criar cartão de vacinação para um pet
    @PostMapping("/pet/{petId}")
    public ResponseEntity<?> criarCartao(@PathVariable Long petId, @RequestBody CartaoDeVacina cartao) {
        Optional<Pet> petOptional = petRepo.findById(petId);
        if (petOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Pet não encontrado.");
        }

        if (cartaoRepo.findByPetId(petId) != null) {
            return ResponseEntity.badRequest().body("Este pet já possui um cartão de vacinação.");
        }

        Pet pet = petOptional.get();
        cartao.setPet(pet);

        cartaoRepo.save(cartao);
        return ResponseEntity.ok("Cartão de vacinação criado com sucesso.");
    }

    // Atualizar cartão de vacinação por ID do cartão
    @PutMapping("/{cartaoId}")
    public ResponseEntity<?> atualizarCartao(
            @PathVariable Long cartaoId,
            @RequestBody CartaoDeVacina cartaoAtualizado) {

        Optional<CartaoDeVacina> cartaoOptional = cartaoRepo.findById(cartaoId);
        if (cartaoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CartaoDeVacina cartaoExistente = cartaoOptional.get();

        cartaoExistente.setNome(cartaoAtualizado.getNome());
        // Atualize outros campos conforme necessário

        cartaoRepo.save(cartaoExistente);
        return ResponseEntity.ok("Cartão de vacinação atualizado com sucesso.");
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

    // Adicionar vacina ao cartão de vacinação
    @PostMapping("/{cartaoId}/vacinas")
    public ResponseEntity<?> adicionarVacinaAoCartao(
            @PathVariable Long cartaoId,
            @RequestBody Vacina vacina) {

        Optional<CartaoDeVacina> cartaoOptional = cartaoRepo.findById(cartaoId);
        if (cartaoOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Cartão de vacinação não encontrado.");
        }

        CartaoDeVacina cartao = cartaoOptional.get();
        vacina.setCartaoDeVacina(cartao);
        cartao.getVacinas().add(vacina);

        cartaoRepo.save(cartao); // Persistir também a vacina

        return ResponseEntity.ok("Vacina adicionada ao cartão com sucesso.");
    }
}
