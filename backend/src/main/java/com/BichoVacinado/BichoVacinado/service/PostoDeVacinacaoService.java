package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.request.PostoDeVacinacaoRequest;
import com.BichoVacinado.BichoVacinado.dto.request.VacinaRequest;
import com.BichoVacinado.BichoVacinado.dto.response.PostoDeVacinacaoResponse;
import com.BichoVacinado.BichoVacinado.dto.response.VacinaResponse;
import com.BichoVacinado.BichoVacinado.model.PostoDeVacinacao;
import com.BichoVacinado.BichoVacinado.model.Vacina;
import com.BichoVacinado.BichoVacinado.repository.PostoDeVacinacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostoDeVacinacaoService {

    private final PostoDeVacinacaoRepository postoDeVacinacaoRepository;

    public PostoDeVacinacaoResponse cadastrar(PostoDeVacinacaoRequest request) {
        PostoDeVacinacao posto = toEntity(request);
        return toResponse(postoDeVacinacaoRepository.save(posto));
    }

    public PostoDeVacinacaoResponse buscarPorId(Long id) {
        PostoDeVacinacao posto = postoDeVacinacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Posto de vacinação não encontrado"));
        return toResponse(posto);
    }

    public PostoDeVacinacaoResponse atualizar(Long id, PostoDeVacinacaoRequest request) {
        PostoDeVacinacao posto = postoDeVacinacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Posto de vacinação não encontrado"));

        posto.setNome(request.getNome());
        posto.setEndereco(request.getEndereco());
        posto.setTelefone(request.getTelefone());

        return toResponse(postoDeVacinacaoRepository.save(posto));
    }

    public void deletar(Long id) {
        PostoDeVacinacao posto = postoDeVacinacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Posto de vacinação não encontrado"));

        postoDeVacinacaoRepository.delete(posto);
    }


    public List<PostoDeVacinacaoResponse> listarTodos() {
        return postoDeVacinacaoRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }


    private PostoDeVacinacao toEntity(PostoDeVacinacaoRequest request) {
        PostoDeVacinacao posto = new PostoDeVacinacao();
        posto.setNome(request.getNome());
        posto.setEndereco(request.getEndereco());
        posto.setTelefone(request.getTelefone());
        return posto;
    }

    private PostoDeVacinacaoResponse toResponse(PostoDeVacinacao posto) {
        return PostoDeVacinacaoResponse.builder()
                .id(posto.getId())
                .nome(posto.getNome())
                .endereco(posto.getEndereco())
                .telefone(posto.getTelefone())
                .build();
    }
}