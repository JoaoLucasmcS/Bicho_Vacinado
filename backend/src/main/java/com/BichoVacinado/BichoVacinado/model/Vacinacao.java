package com.BichoVacinado.BichoVacinado.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacinacao extends BaseEntity {

    @ManyToOne
    private CartaoDeVacina cartaoDeVacina;

    @ManyToOne
    private Vacina vacina;

    @ManyToOne
    private PostoDeVacinacao postoDeVacinacao;
}
