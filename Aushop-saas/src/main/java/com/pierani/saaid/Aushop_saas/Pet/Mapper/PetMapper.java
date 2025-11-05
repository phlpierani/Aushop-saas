package com.pierani.saaid.Aushop_saas.Pet.Mapper;

import com.pierani.saaid.Aushop_saas.Pet.domain.Pet;
import com.pierani.saaid.Aushop_saas.Pet.domain.dto.PetResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {
    PetResponse toResponse(Pet pet);
}
