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
        UsuarioPf tutor = usuarioRepository.findByEmail(petRequest.getTutorEmail())
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));
        Pet pet = Pet.builder()
                .nome(petRequest.getNome())
                .raca(petRequest.getRaca())
                .tipo(petRequest.getTipo())
                .idade(petRequest.getIdade())
                .peso(petRequest.getPeso())
                .tutor(tutor)
                .build();

        log.info("Pet cadastrado com sucesso");
        return petRepository.save(pet);
    }

    public Pet findbyNome(String name) {
        return petRepository.findByNome(name)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pet não encontrado com o nome: " + name));
    }

    public Pet findById(java.util.UUID id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado com o ID: " + id));
    }

    public Pet findByRaca(String raça) {
        return petRepository.findByRaca(raça)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pet não encontrado com a raça: " + raça));
    }

    public Pet findByTipo(String tipo) {
        return petRepository.findByTipo(tipo)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pet não encontrado com o tipo: " + tipo));
    }

    public Pet findByTutor(UsuarioPf tutor) {
        return petRepository.findByTutor(tutor)
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Pet não encontrado com o tutor: " + tutor.getNome()));
    }

    public Pet delete(java.util.UUID id) {
        Pet pet = findById(id);
        petRepository.delete(pet);
        log.info("Pet deletado com sucesso");
        return pet;
    }

    public Pet atualizar(java.util.UUID id, @Valid PetRequest petRequest) {
        Pet petExistente = findById(id);

        petExistente.setNome(petRequest.getNome());
        petExistente.setRaca(petRequest.getRaca());
        petExistente.setTipo(petRequest.getTipo());
        petExistente.setIdade(petRequest.getIdade());
        petExistente.setPeso(petRequest.getPeso());

        log.info("Pet atualizado com sucesso");
        return petRepository.save(petExistente);
    }

}
