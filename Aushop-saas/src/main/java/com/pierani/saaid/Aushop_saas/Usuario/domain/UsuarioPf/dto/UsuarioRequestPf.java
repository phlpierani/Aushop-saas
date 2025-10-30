package com.pierani.saaid.Aushop_saas.Usuario.domain.UsuarioPf.dto;

import com.pierani.saaid.Aushop_saas.Planos.domain.PlanosEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequestPf { // Classe DTO para representar os dados de requisição de um usuário

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
    private String senha;

    @NotNull(message = "Telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 11, message = "CPF deve ter 11 caracteres")
    private String cpf;

    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @NotNull(message = "Tipo do plano é obrigatório")
    private PlanosEnum tipoPlano;

}
