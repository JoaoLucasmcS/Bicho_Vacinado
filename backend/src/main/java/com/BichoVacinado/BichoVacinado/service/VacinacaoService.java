package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.request.VacinacaoRequest;
import com.BichoVacinado.BichoVacinado.dto.response.VacinacaoResponse;
import com.BichoVacinado.BichoVacinado.model.PostoDeVacinacao;
import com.BichoVacinado.BichoVacinado.model.Vacina;
import com.BichoVacinado.BichoVacinado.model.Vacinacao;
import com.BichoVacinado.BichoVacinado.repository.PostoDeVacinacaoRepository;
import com.BichoVacinado.BichoVacinado.repository.VacinaRepository;
import com.BichoVacinado.BichoVacinado.repository.VacinacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacinacaoService {

    private final VacinacaoRepository vacinacaoRepository;
    private final VacinaRepository vacinaRepository;
    private final PostoDeVacinacaoRepository postoRepository;

    public VacinacaoResponse cadastrar(VacinacaoRequest request) {
        Vacina vacina = vacinaRepository.findById(request.getVacinaId())
                .orElseThrow(() -> new RuntimeException("Vacina não encontrada"));

        PostoDeVacinacao posto = postoRepository.findById(request.getPostoDeVacinacaoId())
                .orElseThrow(() -> new RuntimeException("Posto de vacinação não encontrado"));

        Vacinacao vacinacao = new Vacinacao();
        vacinacao.setVacina(vacina);
        vacinacao.setPostoDeVacinacao(posto);

        return toResponse(vacinacaoRepository.save(vacinacao));
    }

    private VacinacaoResponse toResponse(Vacinacao vacinacao) {
        return VacinacaoResponse.builder()
                .id(vacinacao.getId())
                .vacinaId(vacinacao.getVacina().getId())
                .postoDeVacinacaoId(vacinacao.getPostoDeVacinacao().getId())
                .build();
    }
}

