package com.pierani.saaid.Aushop_saas.Pet.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PetResponse {

    private UUID id;

    private String nome;

    private String raça;

    private String tipo;

    private Integer idade;

    private double peso;
}
