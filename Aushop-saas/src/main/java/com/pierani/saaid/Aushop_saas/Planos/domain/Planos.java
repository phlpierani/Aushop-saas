package com.pierani.saaid.Aushop_saas.Planos.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_PLANOS")
public class Planos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private PlanosEnum tipoPlano;

    @Column(nullable = false)
    private String nomePlano;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private double preco;

    @Column(columnDefinition = "TEXT")
    private String beneficios;
}


