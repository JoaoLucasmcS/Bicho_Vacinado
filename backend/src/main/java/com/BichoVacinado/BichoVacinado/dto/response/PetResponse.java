package com.BichoVacinado.BichoVacinado.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetResponse {
    private Long id;
    private String nome;
    private Integer idade;
    private Double peso;
    private Long usuarioId;
}
