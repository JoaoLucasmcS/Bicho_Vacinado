package com.BichoVacinado.BichoVacinado.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacinaResponse {

    private Long id;
    private String nome;
}
