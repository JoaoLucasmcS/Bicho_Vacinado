package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.request.VacinacaoRequest;
import com.BichoVacinado.BichoVacinado.dto.response.VacinacaoResponse;
import com.BichoVacinado.BichoVacinado.model.*;
import com.BichoVacinado.BichoVacinado.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacinacaoService {

    private final VacinacaoRepository vacinacaoRepository;
    private final CartaoDeVacinaRepository cartaoDeVacinaRepository;
    private final VacinaRepository vacinaRepository;
    private final PostoDeVacinacaoRepository postoDeVacinacaoRepository;

    public VacinacaoResponse cadastrar(VacinacaoRequest request) {
        CartaoDeVacina cartao = cartaoDeVacinaRepository.findById(request.getCartaoDeVacinaId())
                .orElseThrow(() -> new RuntimeException("Cartão de vacina não encontrado"));

        Vacina vacina = vacinaRepository.findById(request.getVacinaId())
                .orElseThrow(() -> new RuntimeException("Vacina não encontrada"));

        PostoDeVacinacao posto = postoDeVacinacaoRepository.findById(request.getPostoDeVacinacaoId())
                .orElseThrow(() -> new RuntimeException("Posto de vacinação não encontrado"));

        Vacinacao vacinacao = toEntity(request, cartao, vacina, posto);
        return toResponse(vacinacaoRepository.save(vacinacao));
    }

    public VacinacaoResponse buscarPorId(Long id) {
        Vacinacao vacinacao = vacinacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacinação não encontrada"));
        return toResponse(vacinacao);
    }

    private Vacinacao toEntity(VacinacaoRequest request, CartaoDeVacina cartao, Vacina vacina, PostoDeVacinacao posto) {
        Vacinacao vacinacao = new Vacinacao();
        vacinacao.setCartaoDeVacina(cartao);
        vacinacao.setVacina(vacina);
        vacinacao.setPostoDeVacinacao(posto);
        return vacinacao;
    }

    private VacinacaoResponse toResponse(Vacinacao vacinacao) {
        return VacinacaoResponse.builder()
                .id(vacinacao.getId())
                .cartaoDeVacinaId(vacinacao.getCartaoDeVacina().getId())
                .vacinaId(vacinacao.getVacina().getId())
                .postoDeVacinacaoId(vacinacao.getPostoDeVacinacao().getId())
                .build();
    }
}