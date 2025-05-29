package com.BichoVacinado.BichoVacinado.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDeVacinaResponse {

    private Long id;
    private String nome;
    private Long petId;
    private String nomePet;

    private List<VacinacaoResponse> vacinacoes;
}

