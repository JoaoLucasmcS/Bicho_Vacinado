package com.BichoVacinado.BichoVacinado.repository;

import com.BichoVacinado.BichoVacinado.model.CartaoDeVacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoDeVacinaRepository extends JpaRepository<CartaoDeVacina, Long> {
    CartaoDeVacina findByPetId(Long petId);
}
