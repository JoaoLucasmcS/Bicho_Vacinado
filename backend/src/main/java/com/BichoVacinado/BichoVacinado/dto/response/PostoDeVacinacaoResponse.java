package com.BichoVacinado.BichoVacinado.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostoDeVacinacaoResponse {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
}
