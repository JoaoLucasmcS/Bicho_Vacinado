package com.BichoVacinado.BichoVacinado.controller;

import com.BichoVacinado.BichoVacinado.dto.request.PetRequest;
import com.BichoVacinado.BichoVacinado.dto.request.PetRequest;
import com.BichoVacinado.BichoVacinado.dto.response.PetResponse;
import com.BichoVacinado.BichoVacinado.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public PetResponse cadastrar(@RequestBody @Valid PetRequest request){
        return petService.cadastrar(request);
    }

    @PutMapping("/{id}")
    public PetResponse atualizar(@PathVariable Long id, @RequestBody @Valid PetRequest request){
        return petService.atualizar(id, request);
    }
}
