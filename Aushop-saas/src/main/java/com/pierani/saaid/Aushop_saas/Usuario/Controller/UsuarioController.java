package com.pierani.saaid.Aushop_saas.Usuario.Controller;

import com.pierani.saaid.Aushop_saas.Usuario.Mapper.UsuarioMapper;
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

    @Autowired
    private UsuarioMapper usuarioMapper;

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
                .plano(usuario.getPlano() != null ? usuario.getPlano().getNomePlano() : null)
                .build();

        return ResponseEntity.status(201).body(usuarioResponsePf);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioResponsePf> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(usuarioMapper.toResponse(usuarioImpl.findByEmail(email)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponsePf> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(usuarioMapper.toResponse(usuarioImpl.findById(id)));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<UsuarioResponsePf> findByName(@PathVariable String nome) {
        return ResponseEntity.ok(usuarioMapper.toResponse(usuarioImpl.findByName(nome)));
    }

    @GetMapping("/exists/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(usuarioImpl.existsByEmail(email));
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<UsuarioResponsePf>> listarTodos() {
        var usuarios = usuarioImpl.listarTodos();
        var usuariosResponse = usuarios.stream()
                .map(usuarioMapper::toResponse)
                .toList();
        return ResponseEntity.ok(usuariosResponse);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioResponsePf> atualizar(@PathVariable UUID id,
                                                       @Valid @RequestBody UsuarioRequestPf usuarioRequestPf) {
        var usuarioAtualizado = usuarioImpl.atualizar(id, usuarioRequestPf);
        return ResponseEntity.ok(usuarioMapper.toResponse(usuarioAtualizado));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<UsuarioResponsePf> deletar(@PathVariable UUID id) {
        var usuarioDeletado = usuarioImpl.delete(id);
        return ResponseEntity.ok(usuarioMapper.toResponse(usuarioDeletado));
    }
}

