package com.BichoVacinado.BichoVacinado.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacinacaoResponse {

    private Long id;
    private String localizacao;
    private Long vacinaId;
    private String nomeVacina;
    private Long cartaoDeVacinaId;
    private Long postoDeVacinacaoId;
    private String nomePosto;
}
