package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.response.PetResponse;
import com.BichoVacinado.BichoVacinado.dto.request.PetRequest;
import com.BichoVacinado.BichoVacinado.model.Pet;
import com.BichoVacinado.BichoVacinado.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private PetRepository petRepository;

    public PetResponse cadastrar(PetRequest petRequest){
        Pet pet = new Pet();

        pet.setNome(petRequest.getNome());
        pet.setIdade(petRequest.getIdade());
        pet.setPeso(petRequest.getPeso());
        pet.setEspecie(petRequest.getEspecie());
        pet.setRaca(petRequest.getRaca());
        pet.setHistoricoSaude(petRequest.getHistoricoSaude());
        pet.setUsuarioID(petRequest.getUsuarioId());

        Pet salvo = petRepository.save(pet);

        PetResponse response = new PetResponse();
        response.setId(salvo.getID());
        response.setNome(salvo.getNome());
        response.setEspecie(salvo.getEspecie());
        response.setRaca(salvo.getRaca());
        response.setIdade(salvo.getIdade());
        response.setPeso(salvo.getPeso());
        response.setHistoricoSaude(salvo.getHistoricoSaude());
        response.setUsuarioId(salvo.getUsuarioID());

        return response;

    }

    public PetResponse atualizar(Long id, PetRequest request){

        Pet pet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet não Encontrado"));

        pet.setNome(request.getNome());
        pet.setEspecie(request.getEspecie());
        pet.setRaca(request.getRaca());
        pet.setIdade(request.getIdade());
        pet.setPeso(request.getPeso());
        pet.setHistoricoSaude(request.getHistoricoSaude());
        pet.setUsuarioID(request.getUsuarioId());

        Pet atualizado = petRepository.save(pet);

        PetResponse response = new PetResponse();
        response.setId(atualizado.getID());
        response.setNome(atualizado.getNome());
        response.setEspecie(atualizado.getEspecie());
        response.setRaca(atualizado.getRaca());
        response.setIdade(atualizado.getIdade());
        response.setPeso(atualizado.getPeso());
        response.setHistoricoSaude(atualizado.getHistoricoSaude());
        response.setUsuarioId(atualizado.getUsuarioID());

        return response;
    }
}
