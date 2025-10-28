package com.pierani.saaid.Aushop_saas.Pet.Controller;

import com.pierani.saaid.Aushop_saas.Pet.Service.PetImpl;
import com.pierani.saaid.Aushop_saas.Pet.domain.dto.PetRequest;
import com.pierani.saaid.Aushop_saas.Pet.domain.dto.PetResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetImpl petImpl;

    @PostMapping("/cadastrar")
    public ResponseEntity<PetResponse> cadastrar(@Valid @RequestBody
                                                     PetRequest petRequest) {
        var pet = petImpl.cadastrar(petRequest);

        var petResponse = PetResponse.builder()
                .id(pet.getId())
                .nome(pet.getNome())
                .raça(pet.getRaça())
                .tipo(pet.getTipo())
                .idade(pet.getIdade())
                .peso(pet.getPeso())
                .build();

        return ResponseEntity.status(201).body(petResponse);
    }
}
