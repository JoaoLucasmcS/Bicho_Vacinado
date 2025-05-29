package com.BichoVacinado.BichoVacinado.repository;

import com.BichoVacinado.BichoVacinado.model.PostoDeVacinacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostoDeVacinacaoRepository extends JpaRepository<PostoDeVacinacao, Long> {
}
