package com.BichoVacinado.BichoVacinado.controller;

import com.BichoVacinado.BichoVacinado.model.CartaoDeVacina;
import com.BichoVacinado.BichoVacinado.model.Pet;
import com.BichoVacinado.BichoVacinado.model.Vacina;
import com.BichoVacinado.BichoVacinado.repository.CartaoDeVacinaRepository;
import com.BichoVacinado.BichoVacinado.repository.PetRepository;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
public ResponseEntity<?> criarCartao(@PathVariable Long petId, 
                                     @Valid @RequestBody CartaoDeVacina cartao,
                                     BindingResult result) {
    if (result.hasErrors()) {
        return ResponseEntity.badRequest().body(result.getAllErrors());
    }

    Optional<Pet> optionalPet = petRepo.findById(petId);
    if (optionalPet.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet não encontrado");
    }

    Pet pet = optionalPet.get();

    if (cartaoRepo.findByPetId(pet.getId()). !=) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um cartão para este pet.");
    }

    cartao.setPet(pet);
    cartaoRepo.save(cartao);

    return ResponseEntity.status(HttpStatus.CREATED).body(cartao);
}


    // Atualizar cartão de vacinação por ID do cartão
   @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCartao(@PathVariable Long id, 
                                            @Valid @RequestBody CartaoDeVacina cartaoAtualizado, 
                                            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Optional<CartaoDeVacina> optionalCartao = cartaoRepo.findById(id);
        if (optionalCartao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado");
        }

        CartaoDeVacina cartao = optionalCartao.get();
        cartao.setNome(cartaoAtualizado.getNome());
        // ⚠️ Não deve permitir alterar: pet ou vacinas diretamente!

        cartaoRepo.save(cartao);

        return ResponseEntity.ok(cartao);
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
