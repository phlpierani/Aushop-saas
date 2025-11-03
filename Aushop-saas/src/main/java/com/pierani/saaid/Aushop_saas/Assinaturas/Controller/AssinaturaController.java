package com.pierani.saaid.Aushop_saas.Assinaturas.Controller;

import com.pierani.saaid.Aushop_saas.Assinaturas.domain.Assinatura;
import com.pierani.saaid.Aushop_saas.Assinaturas.domain.dto.AssinaturaRequest;
import com.pierani.saaid.Aushop_saas.Assinaturas.domain.dto.AssinaturaResponse;
import com.pierani.saaid.Aushop_saas.Assinaturas.service.AssinaturaImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assinaturas")
public class AssinaturaController {

    private final AssinaturaImpl assinaturaImpl;

    @PostMapping("/cadastrar/{emailUsuario}")
    public ResponseEntity<AssinaturaResponse> cadastrar(
            @PathVariable String emailUsuario,
            @Valid @RequestBody AssinaturaRequest request) {
        var assinatura = assinaturaImpl.criarAssinatura(emailUsuario, request);
        return ResponseEntity.status(201).body(toResponse(assinatura));
    }

    @GetMapping("/listar-todas")
    public ResponseEntity<List<AssinaturaResponse>> listarTodas() {
        var assinaturas = assinaturaImpl.listarTodas()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/usuario/{emailUsuario}")
    public ResponseEntity<List<AssinaturaResponse>> listarPorUsuario(@PathVariable String emailUsuario) {
        var assinaturas = assinaturaImpl.listarPorUsuario(emailUsuario)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssinaturaResponse> buscarPorId(@PathVariable UUID id) {
        var assinatura = assinaturaImpl.buscarPorId(id);
        return ResponseEntity.ok(toResponse(assinatura));
    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable UUID id) {
        assinaturaImpl.cancelarAssinatura(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ativa")
    public ResponseEntity<Boolean> existeAssinaturaAtiva(
            @RequestParam String emailUsuario,
            @RequestParam String nomePlano) {
        boolean existe = assinaturaImpl.existeAssinaturaAtiva(emailUsuario, nomePlano);
        return ResponseEntity.ok(existe);
    }

    private AssinaturaResponse toResponse(Assinatura assinatura) {
        return AssinaturaResponse.builder()
                .nomeUsuario(assinatura.getUsuario().getNome())
                .nomePlano(assinatura.getPlanos().getNomePlano())
                .dataInicio(assinatura.getDataInicio())
                .dataExpiracao(assinatura.getDataExpiracao())
                .status(assinatura.getStatus())
                .build();

    }
}
