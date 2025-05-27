package com.BichoVacinado.BichoVacinado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import jakarta.validation.constraints.NotBlank;


import java.util.List;

@Entity
@Table(name = "cartao_de_vacina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartaoDeVacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    
    @OneToOne
    @JoinColumn(name = "pet_id", unique = true)
    private Pet pet;

    @OneToMany(mappedBy = "cartaoDeVacina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vacina> vacinas;
}
