package com.pierani.saaid.Aushop_saas.Assinaturas.Mapper;

import com.pierani.saaid.Aushop_saas.Assinaturas.domain.Assinatura;
import com.pierani.saaid.Aushop_saas.Assinaturas.domain.dto.AssinaturaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssinaturaMapper {

    @Mapping(target = "nomeUsuario", expression = "java(assinatura.getUsuario().getNome())")
    @Mapping(target = "nomePlano", expression = "java(assinatura.getPlanos().getNomePlano())")
    AssinaturaResponse toResponse(Assinatura assinatura);
}
