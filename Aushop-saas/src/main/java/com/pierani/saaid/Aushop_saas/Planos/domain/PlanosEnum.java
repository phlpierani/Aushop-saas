package com.pierani.saaid.Aushop_saas.Planos.domain;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum PlanosEnum {

    BASICO(
            "Plano Básico",
            "Ideal para pets que fazem banho quinzenal",
            79.90,
            "1 banhos por mês, 1 tosa simples, sem ração inclusa"
    ),
    PREMIUM(
            "Plano Premium",
            "Perfeito para pets que fazem banho e tosa semanais",
            149.90,
            "2 banhos por mês, 2 tosas, 1 ração por mês, check-up veterinário"
    ),
    VIP(
            "Plano VIP",
            "Para pets exigentes e donos cuidadosos",
            249.90,
            "5 banhos por mês, 4 tosas, 2 rações premium, check-up completo + vacinas"
    );

    private final String nomePlano;
    private final String descricao;
    private final double preco;
    private final String beneficios;
}
