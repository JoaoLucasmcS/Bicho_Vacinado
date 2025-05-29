package com.BichoVacinado.BichoVacinado.service;

import com.BichoVacinado.BichoVacinado.dto.request.VacinaRequest;
import com.BichoVacinado.BichoVacinado.dto.response.VacinaResponse;
import com.BichoVacinado.BichoVacinado.model.Vacina;
import com.BichoVacinado.BichoVacinado.repository.VacinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacinaService {

    private final VacinaRepository vacinaRepository;

    public VacinaResponse cadastrar(VacinaRequest request) {
        Vacina vacina = toEntity(request);
        return toResponse(vacinaRepository.save(vacina));
    }

    public VacinaResponse buscarPorId(Long id) {
        Vacina vacina = vacinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacina não encontrada"));
        return toResponse(vacina);
    }

    public List<VacinaResponse> listarTodos() {
        return vacinaRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private Vacina toEntity(VacinaRequest request) {
        Vacina vacina = new Vacina();
        vacina.setNome(request.getNome());
        return vacina;
    }

    private VacinaResponse toResponse(Vacina vacina) {
        return VacinaResponse.builder()
                .id(vacina.getId())
                .nome(vacina.getNome())
                .build();
    }
}