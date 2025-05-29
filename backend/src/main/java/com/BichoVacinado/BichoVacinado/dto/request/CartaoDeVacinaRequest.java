package com.BichoVacinado.BichoVacinado.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartaoDeVacinaRequest {

    @NotBlank(message = "Nome do cartão é obrigatório")
    private String nome;

    @NotNull(message = "ID do pet é obrigatório")
    private Long petId;
}
