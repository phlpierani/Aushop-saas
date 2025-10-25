package com.pierani.saaid.Aushop_saas.Usuario.Controller;

import com.pierani.saaid.Aushop_saas.Usuario.Service.UsuarioImpl;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.UsuarioPf;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.dto.UsuarioRequestPf;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.dto.UsuarioResponsePf;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios/pf")
public class UsuarioController {

    @Autowired
    private UsuarioImpl usuarioImpl;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponsePf> cadastrar(@Valid @RequestBody
                                                           UsuarioRequestPf usuarioRequestPf) {
        var usuario = usuarioImpl.cadastrar(usuarioRequestPf);

        var usuarioResponsePf = UsuarioResponsePf.builder()
                .id(usuario.getId().toString())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .cpf(usuario.getCpf())
                .telefone(usuario.getTelefone())
                .endereco(usuario.getEndereco())
                .build();

        return ResponseEntity.status(201).body(usuarioResponsePf);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioResponsePf> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(toResponse(usuarioImpl.findByEmail(email)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponsePf> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(toResponse(usuarioImpl.findById(id)));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<UsuarioResponsePf> findByName(@PathVariable String nome) {
        return ResponseEntity.ok(toResponse(usuarioImpl.findByName(nome)));
    }

    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(usuarioImpl.existsByEmail(email));
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<UsuarioResponsePf>> listarTodos() {
        var usuariosResponse = usuarioImpl.listarTodos()
                .stream()
                .map(this::toResponse)
                .toList();
        return ResponseEntity.ok(usuariosResponse);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioResponsePf> atualizar(@PathVariable UUID id,
                                                       @Valid @RequestBody UsuarioRequestPf usuarioRequestPf) {
        var usuarioAtualizado = usuarioImpl.atualizar(id, usuarioRequestPf);
        return ResponseEntity.ok(toResponse(usuarioAtualizado));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<UsuarioResponsePf> deletar(@PathVariable UUID id) {
        var usuarioDeletado = usuarioImpl.delete(id);
        return ResponseEntity.ok(toResponse(usuarioDeletado));
    }

    // ✅ Método utilitário para converter entidade -> response
    private UsuarioResponsePf toResponse(UsuarioPf usuario) {
        return UsuarioResponsePf.builder()
                .id(usuario.getId().toString())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .cpf(usuario.getCpf())
                .telefone(usuario.getTelefone())
                .endereco(usuario.getEndereco())
                .build();
    }
}

