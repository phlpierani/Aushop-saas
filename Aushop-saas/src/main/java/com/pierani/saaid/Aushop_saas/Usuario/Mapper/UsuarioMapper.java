package com.pierani.saaid.Aushop_saas.Usuario.Mapper;

import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.UsuarioPf;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.dto.UsuarioResponsePf;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", expression = "java(usuario.getId().toString())")
    @Mapping(target = "plano", expression = "java(usuario.getPlano() != null ? usuario.getPlano().getNomePlano() : null)")
    UsuarioResponsePf toResponse(UsuarioPf usuario);
}
