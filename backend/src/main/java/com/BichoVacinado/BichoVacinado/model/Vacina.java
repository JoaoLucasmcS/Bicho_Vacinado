package com.BichoVacinado.BichoVacinado.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataAplicacao;
    private String fabricante;

    @ManyToOne
    @JoinColumn(name = "cartao_id")
    private CartaoDeVacina cartaoDeVacina;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public CartaoDeVacina getCartaoDeVacina() {
        return cartaoDeVacina;
    }

    public void setCartaoDeVacina(CartaoDeVacina cartaoDeVacina) {
        this.cartaoDeVacina = cartaoDeVacina;
    }
}
