package com.BichoVacinado.BichoVacinado.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacinaRequest {

    @NotBlank(message = "Nome da vacina é obrigatório")
    private String nome;
}
