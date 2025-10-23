package com.pierani.saaid.Aushop_saas.Usuario.Service;

import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.UsuarioPf;
import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.dto.UsuarioRequestPf;
import com.pierani.saaid.Aushop_saas.Usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Slf4j
@Service
public class UsuarioImpl {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioPf cadastrar(@Valid UsuarioRequestPf usuarioRequestPf) {
        UsuarioPf usuario = UsuarioPf.builder()
                .nome(usuarioRequestPf.getNome())
                .email(usuarioRequestPf.getEmail())
                .senha(usuarioRequestPf.getSenha())
                .cpf(usuarioRequestPf.getCpf())
                .telefone(usuarioRequestPf.getTelefone())
                .endereco(usuarioRequestPf.getEndereco())
                .build();

        log.info("Usuário cadastrado com sucesso");
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioPf> listarTodos() {
        return usuarioRepository.findAll();
    }

    public UsuarioPf findByEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o email: " + email));
    }

    public UsuarioPf findByName(String name) {
        return usuarioRepository.findByNome(name)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o nome: " + name));
    }

    public UsuarioPf findById(java.util.UUID id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}
