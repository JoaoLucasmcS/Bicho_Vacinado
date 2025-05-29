package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.request.VacinaRequest;
import com.BichoVacinado.BichoVacinado.dto.response.VacinaResponse;
import com.BichoVacinado.BichoVacinado.model.Vacina;
import com.BichoVacinado.BichoVacinado.repository.VacinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacinaService {

    private final VacinaRepository vacinaRepository;

    public VacinaResponse cadastrar(VacinaRequest request) {
        Vacina vacina = new Vacina();
        vacina.setNome(request.getNome());
        return toResponse(vacinaRepository.save(vacina));
    }

    public VacinaResponse atualizar(Long id, VacinaRequest request) {
        Vacina vacina = vacinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacina não encontrada"));

        vacina.setNome(request.getNome());
        return toResponse(vacinaRepository.save(vacina));
    }

    private VacinaResponse toResponse(Vacina vacina) {
        return new VacinaResponse(vacina.getId(), vacina.getNome());
    }
}

