package com.pierani.saaid.Aushop_saas.Planos.Mapper;

import com.pierani.saaid.Aushop_saas.Planos.domain.Planos;
import com.pierani.saaid.Aushop_saas.Planos.domain.dto.PlanoResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-04T22:45:43-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class PlanosMapperImpl implements PlanosMapper {

    @Override
    public PlanoResponse toResponse(Planos planos) {
        if ( planos == null ) {
            return null;
        }

        PlanoResponse.PlanoResponseBuilder planoResponse = PlanoResponse.builder();

        planoResponse.nomePlano( planos.getNomePlano() );
        planoResponse.descricao( planos.getDescricao() );
        planoResponse.preco( planos.getPreco() );
        planoResponse.beneficios( planos.getBeneficios() );

        planoResponse.id( planos.getUuid().toString() );

        return planoResponse.build();
    }
}
