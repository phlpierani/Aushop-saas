package com.pierani.saaid.Aushop_saas.Assinaturas.domain;

import com.pierani.saaid.Aushop_saas.Planos.domain.Planos;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.UsuarioPf;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_ASSINATURAS")
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioPf usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plano_id", nullable = false)
    private Planos planos;

    private LocalDate dataInicio;

    private LocalDate dataExpiracao;

    @Enumerated(EnumType.STRING)
    private AssinaturaStatus status;
}
