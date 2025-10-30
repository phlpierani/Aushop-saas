package com.pierani.saaid.Aushop_saas.Usuario.Service;

import com.pierani.saaid.Aushop_saas.Planos.domain.Planos;
import com.pierani.saaid.Aushop_saas.Planos.repository.PlanoRepository;
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

    @Autowired
    private PlanoRepository planoRepository;

    public UsuarioPf cadastrar(@Valid UsuarioRequestPf usuarioRequestPf) {
        Planos plano = planoRepository.findByTipoPlano(usuarioRequestPf.getTipoPlano())
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        UsuarioPf usuario = UsuarioPf.builder()
                .nome(usuarioRequestPf.getNome())
                .email(usuarioRequestPf.getEmail())
                .senha(usuarioRequestPf.getSenha())
                .cpf(usuarioRequestPf.getCpf())
                .telefone(usuarioRequestPf.getTelefone())
                .endereco(usuarioRequestPf.getEndereco())
                .plano(plano)
                .build();

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
        log.info("Esse email já está cadastrado");
        return usuarioRepository.existsByEmail(email);
    }

    public UsuarioPf delete(java.util.UUID id) {
        UsuarioPf usuario = findById(id);
        usuarioRepository.delete(usuario);
        log.info("Usuário deletado com sucesso");
        return usuario;
    }

    public UsuarioPf atualizar(java.util.UUID id, @Valid UsuarioRequestPf usuarioRequestPf) {
        UsuarioPf usuarioExistente = findById(id);

        usuarioExistente.setNome(usuarioRequestPf.getNome());
        usuarioExistente.setEmail(usuarioRequestPf.getEmail());
        usuarioExistente.setSenha(usuarioRequestPf.getSenha());
        usuarioExistente.setCpf(usuarioRequestPf.getCpf());
        usuarioExistente.setTelefone(usuarioRequestPf.getTelefone());
        usuarioExistente.setEndereco(usuarioRequestPf.getEndereco());

        log.info("Usuário atualizado com sucesso");
        return usuarioRepository.save(usuarioExistente);
    }
}
