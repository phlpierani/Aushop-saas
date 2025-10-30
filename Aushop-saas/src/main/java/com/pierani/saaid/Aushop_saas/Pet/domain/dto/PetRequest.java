package com.pierani.saaid.Aushop_saas.Pet.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PetRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Raça é obrigatória")
    private String raca;

    @NotBlank(message = "Tipo é obrigatório")
    private String tipo;

    @NotNull(message = "Idade é obrigatória")
    private Integer idade;

    @NotNull(message = "Peso é obrigatório")
    private double peso;

    // PetRequest.java
    @NotNull(message = "Tutor é obrigatório")
    private UUID tutorId;
}
