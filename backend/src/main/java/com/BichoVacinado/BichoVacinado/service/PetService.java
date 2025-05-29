package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.response.PetResponse;
import com.BichoVacinado.BichoVacinado.dto.request.PetRequest;
import com.BichoVacinado.BichoVacinado.model.Pet;
import com.BichoVacinado.BichoVacinado.model.Usuario;
import com.BichoVacinado.BichoVacinado.repository.PetRepository;
import com.BichoVacinado.BichoVacinado.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final UsuarioRepository usuarioRepository;

    public PetResponse cadastrar(PetRequest request) {
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Dono não encontrado"));

        Pet pet = toEntity(request, usuario);
        return toResponse(petRepository.save(pet));
    }

    public PetResponse atualizar(Long id, PetRequest request) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        pet.setNome(request.getNome());
        pet.setIdade(request.getIdade());
        pet.setPeso(request.getPeso());

        return toResponse(petRepository.save(pet));
    }

    public void deletar(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        petRepository.delete(pet);
    }

    public PetResponse buscarPorId(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));
        return toResponse(pet);
    }

    public List<PetResponse> listarTodos() {
        return petRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private Pet toEntity(PetRequest request, Usuario usuario) {
        Pet pet = new Pet();
        pet.setNome(request.getNome());
        pet.setIdade(request.getIdade());
        pet.setPeso(request.getPeso());
        pet.setDono(usuario);
        return pet;
    }

    private PetResponse toResponse(Pet pet) {
        return PetResponse.builder()
                .id(pet.getId())
                .nome(pet.getNome())
                .idade(pet.getIdade())
                .peso(pet.getPeso())
                .usuarioId(pet.getDono().getId())
                .build();
    }
}


