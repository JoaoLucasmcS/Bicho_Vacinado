package com.BichoVacinado.BichoVacinado.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacinacaoRequest {

    @NotNull(message = "ID da vacina é obrigatório")
    private Long vacinaId;

    @NotNull(message = "ID do cartão de vacina é obrigatório")
    private Long cartaoDeVacinaId;

    private Long postoDeVacinacaoId; // Opcional
}

