package com.BichoVacinado.BichoVacinado.dto.response;

import lombok.Data;

@Data
public class PetResponse {
    private Long id;
    private String nome;
    private String especie;
    private String raca;
    private Integer idade;
    private Double peso;
    private String historicoSaude;
    private Long usuarioId;
}
