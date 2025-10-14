package com.pierani.saaid.Aushop_saas.Usuario.Service;

import com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf;
import com.pierani.saaid.Aushop_saas.Usuario.dto.UsuarioRequestPf;
import com.pierani.saaid.Aushop_saas.Usuario.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioPf cadastrar(@Valid UsuarioRequestPf usuarioRequestPf) {
        UsuarioPf usuario = UsuarioPf.builder()
                .nome(usuarioRequestPf.getNome())
                .email(usuarioRequestPf.getEmail())
                .senha(usuarioRequestPf.getSenha())
                .cpf(usuarioRequestPf.getCpf())
                .telefone(usuarioRequestPf.getTelefone())
                .build();

        log.info("Usuário cadastrado com sucesso");
        return usuarioRepository.save(usuario);
    }
}
