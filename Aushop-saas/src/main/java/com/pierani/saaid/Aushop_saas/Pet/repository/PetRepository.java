package com.pierani.saaid.Aushop_saas.Pet.repository;

import com.pierani.saaid.Aushop_saas.Pet.domain.Pet;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.UsuarioPf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PetRepository extends JpaRepository<Pet, UUID> {

    List<Pet> findAll();
    List<Pet> findByNome(String nome);
    Optional<Pet> findById(UUID id);
    List<Pet> findByTipo(String tipo);
    List<Pet> findByRaca(String raca);
    List<Pet> findByTutor(UsuarioPf tutor);
}
