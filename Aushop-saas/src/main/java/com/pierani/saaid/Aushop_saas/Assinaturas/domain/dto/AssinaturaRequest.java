package com.pierani.saaid.Aushop_saas.Assinaturas.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssinaturaRequest {

    @NotBlank
    private String nomePlano; // exemplo: "BASICO"
}
