package com.pierani.saaid.Aushop_saas.Planos.domain.dto;

import com.pierani.saaid.Aushop_saas.Planos.domain.PlanosEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanosRequest {

    @NotNull(message = "Tipo do plano é obrigatório")
    private PlanosEnum tipoPlano;
}

