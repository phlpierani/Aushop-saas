package com.pierani.saaid.Aushop_saas.Usuario.Controller;

import com.pierani.saaid.Aushop_saas.Usuario.Service.UsuarioImpl;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.dto.UsuarioRequestPf;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.dto.UsuarioResponsePf;
import com.pierani.saaid.Aushop_saas.Usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios/pf")
public class UsuarioController {

    @Autowired
    private UsuarioImpl usuarioImpl;

    @Autowired
    private UsuarioRepository usuarioRepository;

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
}
