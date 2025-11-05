package com.pierani.saaid.Aushop_saas.Pet.Mapper;

import com.pierani.saaid.Aushop_saas.Pet.domain.Pet;
import com.pierani.saaid.Aushop_saas.Pet.domain.dto.PetResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-04T22:45:43-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class PetMapperImpl implements PetMapper {

    @Override
    public PetResponse toResponse(Pet pet) {
        if ( pet == null ) {
            return null;
        }

        PetResponse.PetResponseBuilder petResponse = PetResponse.builder();

        petResponse.id( pet.getId() );
        petResponse.nome( pet.getNome() );
        petResponse.raca( pet.getRaca() );
        petResponse.tipo( pet.getTipo() );
        petResponse.idade( pet.getIdade() );
        petResponse.peso( pet.getPeso() );

        return petResponse.build();
    }
}
