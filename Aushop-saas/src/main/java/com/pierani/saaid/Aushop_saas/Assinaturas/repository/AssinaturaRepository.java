package com.pierani.saaid.Aushop_saas.Assinaturas.repository;

import com.pierani.saaid.Aushop_saas.Assinaturas.domain.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AssinaturaRepository extends JpaRepository<Assinatura, UUID> {

    List<Assinatura> findByUsuarioEmail(String email);

    boolean existsByUsuarioEmailAndPlanos_NomePlano(String email, String nomePlano);
}