package com.pierani.saaid.Aushop_saas.Planos.Controller;

import com.pierani.saaid.Aushop_saas.Planos.Mapper.PlanosMapper;
import com.pierani.saaid.Aushop_saas.Planos.domain.PlanosEnum;
import com.pierani.saaid.Aushop_saas.Planos.domain.dto.PlanoResponse;
import com.pierani.saaid.Aushop_saas.Planos.domain.dto.PlanosRequest;
import com.pierani.saaid.Aushop_saas.Planos.service.PlanosImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanosController {

    @Autowired
    private PlanosImpl planosImpl;

    @Autowired
    private PlanosMapper planosMapper;

    @PostMapping("/cadastrar")
    public ResponseEntity<PlanoResponse> cadastrar(@Valid @RequestBody PlanosRequest planosRequest) {
        var plano = planosImpl.cadastrar(planosRequest);
        return ResponseEntity.status(201).body(planosMapper.toResponse(plano));
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<PlanoResponse>> listarTodos() {
        var planos = planosImpl.listarTodos().stream()
                .map(planosMapper::toResponse)
                .toList();
        return ResponseEntity.ok(planos);
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<PlanoResponse> findByTipo(@PathVariable PlanosEnum tipo) {
        return ResponseEntity.ok(planosMapper.toResponse(planosImpl.findByTipo(tipo)));
    }
}


