package com.pierani.saaid.Aushop_saas.Usuario.Mapper;

import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.UsuarioPf;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.dto.UsuarioResponsePf;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-04T22:45:43-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioResponsePf toResponse(UsuarioPf usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioResponsePf.UsuarioResponsePfBuilder usuarioResponsePf = UsuarioResponsePf.builder();

        usuarioResponsePf.nome( usuario.getNome() );
        usuarioResponsePf.email( usuario.getEmail() );
        usuarioResponsePf.cpf( usuario.getCpf() );
        usuarioResponsePf.telefone( usuario.getTelefone() );
        usuarioResponsePf.endereco( usuario.getEndereco() );

        usuarioResponsePf.id( usuario.getId().toString() );
        usuarioResponsePf.plano( usuario.getPlano() != null ? usuario.getPlano().getNomePlano() : null );

        return usuarioResponsePf.build();
    }
}
