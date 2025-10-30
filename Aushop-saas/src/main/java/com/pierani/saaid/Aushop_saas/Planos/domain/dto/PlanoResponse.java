package com.pierani.saaid.Aushop_saas.Planos.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanoResponse {

    private String id;
    private String nomePlano;
    private String descricao;
    private double preco;
    private String beneficios;
}
