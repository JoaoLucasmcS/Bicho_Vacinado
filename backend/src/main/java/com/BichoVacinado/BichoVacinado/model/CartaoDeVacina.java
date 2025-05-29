package com.BichoVacinado.BichoVacinado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import jakarta.validation.constraints.NotBlank;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartaoDeVacina extends BaseEntity {

    private String nome;

    @OneToOne
    @JoinColumn(name = "id_pet")
    private Pet pet;

    @OneToMany(mappedBy = "cartaoDeVacina", cascade = CascadeType.ALL)
    private List<Vacinacao> vacinacoes = new ArrayList<>();
}
