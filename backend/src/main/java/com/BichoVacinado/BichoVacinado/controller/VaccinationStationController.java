package com.BichoVacinado.BichoVacinado.controller;

import com.BichoVacinado.BichoVacinado.dto.request.StationRequest;
import com.BichoVacinado.BichoVacinado.dto.response.StationResponse;
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
    public StationResponse cadastrar(@RequestBody @Valid StationRequest request){
        return stationService.cadastrar(request);
    }

    @PutMapping("/{id}")
    public StationResponse atualizar(@PathVariable Long id, @RequestBody @Valid StationRequest request){
        return stationService.atualizar(id, request);
    }
}