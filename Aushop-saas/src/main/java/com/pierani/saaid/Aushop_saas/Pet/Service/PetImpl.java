package com.pierani.saaid.Aushop_saas.Pet.Service;

import com.pierani.saaid.Aushop_saas.Pet.domain.Pet;
import com.pierani.saaid.Aushop_saas.Pet.domain.dto.PetRequest;
import com.pierani.saaid.Aushop_saas.Pet.repository.PetRepository;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.UsuarioPf;
import com.pierani.saaid.Aushop_saas.Usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PetImpl {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Pet cadastrar(@Valid PetRequest petRequest){
        UsuarioPf tutor = usuarioRepository.findById(petRequest.getTutorId())
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));
        Pet pet = Pet.builder()
                .nome(petRequest.getNome())
                .raça(petRequest.getRaça())
                .tipo(petRequest.getTipo())
                .idade(petRequest.getIdade())
                .peso(petRequest.getPeso())
                .tutor(tutor)
                .build();

        log.info("Pet cadastrado com sucesso");
        return petRepository.save(pet);
    }

}
