package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.response.PostoDeVacinacaoResponse;
import com.BichoVacinado.BichoVacinado.dto.request.PostoDeVacinacaoRequest;
import com.BichoVacinado.BichoVacinado.model.PostoDeVacinacao;
import com.BichoVacinado.BichoVacinado.repository.PostoDeVacinacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    @Autowired
    private PostoDeVacinacaoRepository postoDeVacinacaoRepository;

    public PostoDeVacinacaoResponse cadastrar(PostoDeVacinacaoRequest postoDeVacinacaoRequest){

        PostoDeVacinacao station = new PostoDeVacinacao();

        station.setNome(postoDeVacinacaoRequest.getNome());
        station.setEndereco(postoDeVacinacaoRequest.getEndereco());
        station.setTelefone(postoDeVacinacaoRequest.getTelefone());

        PostoDeVacinacao salvo = postoDeVacinacaoRepository.save(station);

        PostoDeVacinacaoResponse response = new PostoDeVacinacaoResponse();
        response.setId(salvo.getId());
        response.setNome(salvo.getNome());
        response.setEndereco(salvo.getEndereco());
        response.setTelefone(salvo.getTelefone());

        return response;

    }

    public PostoDeVacinacaoResponse atualizar(Long id, PostoDeVacinacaoRequest request){

        PostoDeVacinacao station = postoDeVacinacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Station não Encontrado"));

        station.setNome(request.getNome());
        station.setEndereco(request.getEndereco());
        station.setTelefone(request.getTelefone());

        PostoDeVacinacao atualizado = postoDeVacinacaoRepository.save(station);

        PostoDeVacinacaoResponse response = new PostoDeVacinacaoResponse();

        response.setId(atualizado.getId());
        response.setNome(atualizado.getNome());
        response.setEndereco(atualizado.getEndereco());
        response.setTelefone(atualizado.getTelefone());

        return response;
    }
}
