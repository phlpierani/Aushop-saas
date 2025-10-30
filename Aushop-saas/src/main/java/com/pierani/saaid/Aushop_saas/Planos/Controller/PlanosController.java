package com.pierani.saaid.Aushop_saas.Planos.Controller;

import com.pierani.saaid.Aushop_saas.Planos.domain.Planos;
import com.pierani.saaid.Aushop_saas.Planos.domain.PlanosEnum;
import com.pierani.saaid.Aushop_saas.Planos.domain.dto.PlanoResponse;
import com.pierani.saaid.Aushop_saas.Planos.domain.dto.PlanosRequest;
import com.pierani.saaid.Aushop_saas.Planos.service.PlanosImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanosController {

    @Autowired
    private PlanosImpl planosImpl;

    @PostMapping("/cadastrar")
    public ResponseEntity<PlanoResponse> cadastrar(@Valid @RequestBody PlanosRequest planosRequest) {
        var plano = planosImpl.cadastrar(planosRequest);
        return ResponseEntity.status(201).body(toResponse(plano));
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<PlanoResponse>> listarTodos() {
        var planos = planosImpl.listarTodos().stream().map(this::toResponse).toList();
        return ResponseEntity.ok(planos);
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<PlanoResponse> findByTipo(@PathVariable PlanosEnum tipo) {
        return ResponseEntity.ok(toResponse(planosImpl.findByTipo(tipo)));
    }

    @GetMapping("/tipos")
    public ResponseEntity<List<PlanoResponse>> listarTipos() {
        var tipos = Arrays.stream(PlanosEnum.values())
                .map(tipo -> PlanoResponse.builder()
                        .nomePlano(tipo.getNomePlano())
                        .descricao(tipo.getDescricao())
                        .preco(tipo.getPreco())
                        .beneficios(tipo.getBeneficios())
                        .build())
                .toList();
        return ResponseEntity.ok(tipos);
    }


    private PlanoResponse toResponse(Planos planos) {
        return PlanoResponse.builder()
                .id(planos.getUuid().toString())
                .nomePlano(planos.getNomePlano())
                .descricao(planos.getDescricao())
                .preco(planos.getPreco())
                .beneficios(planos.getBeneficios())
                .build();
    }
}


