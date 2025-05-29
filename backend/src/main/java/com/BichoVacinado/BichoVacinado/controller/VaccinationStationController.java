package com.BichoVacinado.BichoVacinado.controller;

import com.BichoVacinado.BichoVacinado.dto.request.PostoDeVacinacaoRequest;
import com.BichoVacinado.BichoVacinado.dto.response.PostoDeVacinacaoResponse;
import com.BichoVacinado.BichoVacinado.service.StationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/station")
public class VaccinationStationController {

    @Autowired
    private StationService stationService;

    @PostMapping
    public PostoDeVacinacaoResponse cadastrar(@RequestBody @Valid PostoDeVacinacaoRequest request){
        return stationService.cadastrar(request);
    }

    @PutMapping("/{id}")
    public PostoDeVacinacaoResponse atualizar(@PathVariable Long id, @RequestBody @Valid PostoDeVacinacaoRequest request){
        return stationService.atualizar(id, request);
    }
}