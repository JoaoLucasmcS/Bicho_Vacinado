package com.BichoVacinado.BichoVacinado.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class StationRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "Telefone é obrigatório")
    @Length(min = 10, message = "Telefone precisa ter, pelo menos, 10 dígitos.")
    private String telefone;

    // Getters e Setters manuais
    public String getNome() { return nome; }
    public void setNome(String nome) {this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) {this.endereco = endereco; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
