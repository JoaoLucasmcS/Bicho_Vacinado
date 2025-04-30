package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.response.StationResponse;
import com.BichoVacinado.BichoVacinado.dto.request.StationRequest;
import com.BichoVacinado.BichoVacinado.model.VaccinationStation;
import com.BichoVacinado.BichoVacinado.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public StationResponse cadastrar(StationRequest stationRequest){

        VaccinationStation station = new VaccinationStation();

        station.setNome(stationRequest.getNome());
        station.setEndereco(stationRequest.getEndereco());
        station.setTelefone(stationRequest.getTelefone());

        VaccinationStation salvo = stationRepository.save(station);

        StationResponse response = new StationResponse();
        response.setId(salvo.getId());
        response.setNome(salvo.getNome());
        response.setEndereco(salvo.getEndereco());
        response.setTelefone(salvo.getTelefone());

        return response;

    }

    public StationResponse atualizar(Long id, StationRequest request){

        VaccinationStation station = stationRepository.findById(id).orElseThrow(() -> new RuntimeException("Station não Encontrado"));

        station.setNome(request.getNome());
        station.setEndereco(request.getEndereco());
        station.setTelefone(request.getTelefone());

        VaccinationStation atualizado = stationRepository.save(station);

        StationResponse response = new StationResponse();

        response.setId(atualizado.getId());
        response.setNome(atualizado.getNome());
        response.setEndereco(atualizado.getEndereco());
        response.setTelefone(atualizado.getTelefone());

        return response;
    }
}
