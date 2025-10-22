package com.pierani.saaid.Aushop_saas.Usuario.repository;

import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.UsuarioPf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioPf , UUID> {

    Optional<UsuarioPf> findByEmail(String email); // Método para encontrar usuário por email

    boolean existsByEmail(String email); // Verifica se o email já está cadastrado

    Optional<UsuarioPf> findById(UUID id);

    Optional<UsuarioPf> findByNome(String nome);

    List<UsuarioPf> findAll();

}
