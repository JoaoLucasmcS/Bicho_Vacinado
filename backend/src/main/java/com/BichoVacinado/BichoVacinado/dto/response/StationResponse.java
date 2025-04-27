package com.BichoVacinado.BichoVacinado.dto.response;

import lombok.Data;

@Data
public class StationResponse {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
}
