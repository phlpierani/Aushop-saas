package com.pierani.saaid.Aushop_saas.Pet.repository;

import com.pierani.saaid.Aushop_saas.Pet.domain.Pet;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.UsuarioPf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, UUID> {

    List<Pet> findAll();
    List<Pet> findByNome(String nome);
    List<Pet> findByTipo(String tipo);
    List<Pet> findByRaça(String raça);
    List<Pet> findByTutor(UsuarioPf tutor);
}
