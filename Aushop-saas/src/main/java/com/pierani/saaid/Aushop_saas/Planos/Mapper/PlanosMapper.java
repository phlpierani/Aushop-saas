package com.pierani.saaid.Aushop_saas.Planos.Mapper;

import com.pierani.saaid.Aushop_saas.Planos.domain.Planos;
import com.pierani.saaid.Aushop_saas.Planos.domain.dto.PlanoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlanosMapper {

    @Mapping(target = "id", expression = "java(planos.getUuid().toString())")
    PlanoResponse toResponse(Planos planos);
}
