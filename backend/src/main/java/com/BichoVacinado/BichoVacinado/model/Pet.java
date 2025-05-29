package com.BichoVacinado.BichoVacinado.model;

import com.BichoVacinado.BichoVacinado.model.utils.TipoPet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet extends BaseEntity {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private Double peso;

    @ManyToOne
    private Usuario dono;

    @Enumerated(EnumType.STRING)
    private TipoPet tipo;

    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
    private CartaoDeVacina cartaoDeVacina;
}

