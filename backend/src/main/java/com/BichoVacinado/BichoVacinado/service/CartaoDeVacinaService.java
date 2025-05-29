package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.request.CartaoDeVacinaRequest;
import com.BichoVacinado.BichoVacinado.dto.response.CartaoDeVacinaResponse;
import com.BichoVacinado.BichoVacinado.model.CartaoDeVacina;
import com.BichoVacinado.BichoVacinado.model.Pet;
import com.BichoVacinado.BichoVacinado.repository.CartaoDeVacinaRepository;
import com.BichoVacinado.BichoVacinado.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartaoDeVacinaService {

    private final CartaoDeVacinaRepository cartaoDeVacinaRepository;
    private final PetRepository petRepository;

    public CartaoDeVacinaResponse cadastrar(CartaoDeVacinaRequest request) {
        Pet pet = petRepository.findById(request.getPetId())
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        CartaoDeVacina cartao = toEntity(request, pet);
        return toResponse(cartaoDeVacinaRepository.save(cartao));
    }

    public CartaoDeVacinaResponse buscarPorId(Long id) {
        CartaoDeVacina cartao = cartaoDeVacinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão de vacina não encontrado"));
        return toResponse(cartao);
    }

    public CartaoDeVacinaResponse buscarPorPetId(Long petId) {
        CartaoDeVacina cartao = cartaoDeVacinaRepository.findByPetId(petId)
                .orElseThrow(() -> new RuntimeException("Cartão de vacina não encontrado para este pet"));
        return toResponse(cartao);
    }

    private CartaoDeVacina toEntity(CartaoDeVacinaRequest request, Pet pet) {
        CartaoDeVacina cartao = new CartaoDeVacina();
        cartao.setNome(request.getNome());
        cartao.setPet(pet);
        return cartao;
    }

    private CartaoDeVacinaResponse toResponse(CartaoDeVacina cartao) {
        return CartaoDeVacinaResponse.builder()
                .id(cartao.getId())
                .nome(cartao.getNome())
                .petId(cartao.getPet().getId())
                .build();
    }
}