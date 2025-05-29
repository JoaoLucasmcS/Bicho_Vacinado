package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.response.PostoDeVacinacaoResponse;
import com.BichoVacinado.BichoVacinado.dto.request.PostoDeVacinacaoRequest;
import com.BichoVacinado.BichoVacinado.model.PostoDeVacinacao;
import com.BichoVacinado.BichoVacinado.repository.PostoDeVacinacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostoDeVacinacaoService {

    private final PostoDeVacinacaoRepository postoRepository;

    public PostoDeVacinacaoResponse cadastrar(PostoDeVacinacaoRequest request) {
        PostoDeVacinacao posto = new PostoDeVacinacao();
        posto.setNome(request.getNome());
        posto.setEndereco(request.getEndereco());
        return toResponse(postoRepository.save(posto));
    }

    public PostoDeVacinacaoResponse atualizar(Long id, PostoDeVacinacaoRequest request) {
        PostoDeVacinacao posto = postoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Posto de vacinação não encontrado"));

        posto.setNome(request.getNome());
        posto.setEndereco(request.getEndereco());
        return toResponse(postoRepository.save(posto));
    }

    private PostoDeVacinacaoResponse toResponse(PostoDeVacinacao posto) {
        return PostoDeVacinacaoResponse.builder()
                .id(posto.getId())
                .nome(posto.getNome())
                .endereco(posto.getEndereco())
                .build();
    }
}
