package com.BichoVacinado.BichoVacinado.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Espécie é obrigatória")
    private String especie;

    private String raca;

    @Positive(message = "Idade deve ser positiva")
    private Integer idade;

    @Positive(message = "Peso deve ser positivo")
    private Double peso;

    @NotNull(message = "ID do usuário é obrigatório")
    private Long usuarioId;
}
