package com.pierani.saaid.Aushop_saas.Planos.repository;

import com.pierani.saaid.Aushop_saas.Planos.domain.Planos;
import com.pierani.saaid.Aushop_saas.Planos.domain.PlanosEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlanoRepository extends JpaRepository<Planos, UUID> {
    Optional<Planos> findByTipoPlano(PlanosEnum tipoPlano);
}

