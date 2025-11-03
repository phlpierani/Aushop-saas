package com.pierani.saaid.Aushop_saas.Assinaturas.service;

import com.pierani.saaid.Aushop_saas.Assinaturas.domain.Assinatura;
import com.pierani.saaid.Aushop_saas.Assinaturas.domain.AssinaturaStatus;
import com.pierani.saaid.Aushop_saas.Assinaturas.domain.dto.AssinaturaRequest;
import com.pierani.saaid.Aushop_saas.Assinaturas.repository.AssinaturaRepository;
import com.pierani.saaid.Aushop_saas.Planos.repository.PlanoRepository;
import com.pierani.saaid.Aushop_saas.Usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssinaturaImpl {

    private final PlanoRepository planoRepository;
    private final UsuarioRepository usuarioRepository;
    private final AssinaturaRepository assinaturaRepository;

    public Assinatura criarAssinatura(String emailUsuario, AssinaturaRequest request) {

        var usuario = usuarioRepository.findByEmail(emailUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var tipoPlano = com.pierani.saaid.Aushop_saas.Planos.domain.PlanosEnum.valueOf(request.getNomePlano().toUpperCase());

        var plano = planoRepository.findByTipoPlano(tipoPlano)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        var assinatura = Assinatura.builder()
                .usuario(usuario)
                .planos(plano)
                .dataInicio(LocalDate.now())
                .dataExpiracao(LocalDate.now().plusMonths(1))
                .status(AssinaturaStatus.ATIVA)
                .build();

        return assinaturaRepository.save(assinatura);
    }

    public List<Assinatura> listarPorUsuario(String emailUsuario) {
        return assinaturaRepository.findByUsuarioEmail(emailUsuario);
    }

    public List<Assinatura> listarTodas() {
        return assinaturaRepository.findAll();
    }

    public Assinatura buscarPorId(UUID id) {
        return assinaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assinatura não encontrada"));
    }

    public void cancelarAssinatura(UUID id) {
        var assinatura = buscarPorId(id);
        assinatura.setStatus(AssinaturaStatus.CANCELADA);
        assinaturaRepository.save(assinatura);
    }

    @Scheduled(cron = "0 0 2 * * *") // Executa todo dia às 2h da manhã
    public void expirarAssinaturas() {
        var hoje = LocalDate.now();
        var assinaturas = assinaturaRepository.findAll();
        for (var assinatura : assinaturas) {
            if (assinatura.getDataExpiracao().isBefore(hoje) && assinatura.getStatus() == AssinaturaStatus.ATIVA) {
                assinatura.setStatus(AssinaturaStatus.EXPIRADA);
                assinaturaRepository.save(assinatura);
            }
        }
    }

    public boolean existeAssinaturaAtiva(String emailUsuario, String nomePlano) {
        return assinaturaRepository.existsByUsuarioEmailAndPlanos_NomePlano(emailUsuario, nomePlano);
    }

}
