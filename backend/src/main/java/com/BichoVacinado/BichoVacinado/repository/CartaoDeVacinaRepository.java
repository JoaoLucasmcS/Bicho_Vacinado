package com.BichoVacinado.BichoVacinado.repository;

import com.BichoVacinado.BichoVacinado.model.CartaoDeVacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoDeVacinaRepository extends JpaRepository<CartaoDeVacina, Long> {
    @Query("SELECT c FROM CartaoDeVacina c WHERE c.pet.id = :petId")
    Optional<CartaoDeVacina> findByPetId(@Param("petId") Long petId);
}
