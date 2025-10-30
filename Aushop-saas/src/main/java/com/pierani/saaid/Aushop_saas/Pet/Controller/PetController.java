package com.pierani.saaid.Aushop_saas.Pet.Controller;

import com.pierani.saaid.Aushop_saas.Pet.Service.PetImpl;
import com.pierani.saaid.Aushop_saas.Pet.domain.dto.PetRequest;
import com.pierani.saaid.Aushop_saas.Pet.domain.dto.PetResponse;
import com.pierani.saaid.Aushop_saas.Usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetImpl petImpl;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<PetResponse> cadastrar(@Valid @RequestBody
                                                 PetRequest petRequest) {
        var pet = petImpl.cadastrar(petRequest);

        var petResponse = PetResponse.builder()
                .id(pet.getId())
                .nome(pet.getNome())
                .raca(pet.getRaca())
                .tipo(pet.getTipo())
                .idade(pet.getIdade())
                .peso(pet.getPeso())
                .build();

        return ResponseEntity.status(201).body(petResponse);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<PetResponse> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(toResponse(petImpl.findbyNome(nome)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponse> findById(@PathVariable java.util.UUID id) {
        return ResponseEntity.ok(toResponse(petImpl.findById(id)));
    }

    @GetMapping("/raca/{raca}")
    public ResponseEntity<PetResponse> findByRaca(@PathVariable String raca)
    {
        return ResponseEntity.ok(toResponse(petImpl.findByRaca(raca)));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<PetResponse> findByTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(toResponse(petImpl.findByTipo(tipo)));
    }

    @GetMapping("/tutor/{tutorId}")
    public ResponseEntity<PetResponse> findByTutor(@PathVariable java.util.UUID tutorId) {
        var tutor = usuarioRepository.findById(tutorId)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));
        return ResponseEntity.ok(toResponse(petImpl.findByTutor(tutor)));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable java.util.UUID id) {
        petImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PetResponse> atualizar(@PathVariable java.util.UUID id,
                                                @Valid @RequestBody PetRequest petRequest) {
        var petAtualizado = petImpl.atualizar(id, petRequest);
        return ResponseEntity.ok(toResponse(petAtualizado));
    }

    private PetResponse toResponse(com.pierani.saaid.Aushop_saas.Pet.domain.Pet pet) {
        return PetResponse.builder()
                .id(pet.getId())
                .nome(pet.getNome())
                .raca(pet.getRaca())
                .tipo(pet.getTipo())
                .idade(pet.getIdade())
                .peso(pet.getPeso())
                .build();
    }
}
