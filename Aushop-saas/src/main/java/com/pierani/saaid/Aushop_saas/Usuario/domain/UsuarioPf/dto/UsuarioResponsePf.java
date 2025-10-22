package com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponsePf { // Classe de resposta para usuário pessoa física

    private String id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String endereco;

}
