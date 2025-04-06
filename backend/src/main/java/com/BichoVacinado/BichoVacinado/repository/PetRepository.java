package com.BichoVacinado.BichoVacinado.repository;

import com.BichoVacinado.BichoVacinado.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
