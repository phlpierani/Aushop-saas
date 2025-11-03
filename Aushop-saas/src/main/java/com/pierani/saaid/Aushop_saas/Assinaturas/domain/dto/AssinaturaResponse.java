package com.pierani.saaid.Aushop_saas.Assinaturas.domain.dto;

import com.pierani.saaid.Aushop_saas.Assinaturas.domain.AssinaturaStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssinaturaResponse {
    private String nomeUsuario;
    private String nomePlano;
    private LocalDate dataInicio;
    private LocalDate dataExpiracao;
    private AssinaturaStatus status;
}
