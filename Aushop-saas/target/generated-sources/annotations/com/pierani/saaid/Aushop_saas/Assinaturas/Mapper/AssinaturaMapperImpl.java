package com.pierani.saaid.Aushop_saas.Assinaturas.Mapper;

import com.pierani.saaid.Aushop_saas.Assinaturas.domain.Assinatura;
import com.pierani.saaid.Aushop_saas.Assinaturas.domain.dto.AssinaturaResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-04T22:45:43-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class AssinaturaMapperImpl implements AssinaturaMapper {

    @Override
    public AssinaturaResponse toResponse(Assinatura assinatura) {
        if ( assinatura == null ) {
            return null;
        }

        AssinaturaResponse.AssinaturaResponseBuilder assinaturaResponse = AssinaturaResponse.builder();

        assinaturaResponse.dataInicio( assinatura.getDataInicio() );
        assinaturaResponse.dataExpiracao( assinatura.getDataExpiracao() );
        assinaturaResponse.status( assinatura.getStatus() );

        assinaturaResponse.nomeUsuario( assinatura.getUsuario().getNome() );
        assinaturaResponse.nomePlano( assinatura.getPlanos().getNomePlano() );

        return assinaturaResponse.build();
    }
}
