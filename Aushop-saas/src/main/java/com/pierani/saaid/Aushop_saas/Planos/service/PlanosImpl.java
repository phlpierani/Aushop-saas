package com.pierani.saaid.Aushop_saas.Planos.service;

import com.pierani.saaid.Aushop_saas.Planos.domain.Planos;
import com.pierani.saaid.Aushop_saas.Planos.domain.PlanosEnum;
import com.pierani.saaid.Aushop_saas.Planos.domain.dto.PlanosRequest;
import com.pierani.saaid.Aushop_saas.Planos.repository.PlanoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlanosImpl {

    @Autowired
    private PlanoRepository planoRepository;

    public Planos cadastrar(@Valid PlanosRequest planosRequest){
        PlanosEnum tipo = planosRequest.getTipoPlano();

        Planos plano = Planos.builder()
                .tipoPlano(tipo)
                .nomePlano(tipo.getNomePlano())
                .descricao(tipo.getDescricao())
                .preco(tipo.getPreco())
                .beneficios(tipo.getBeneficios())
                .build();

        return planoRepository.save(plano);
    }

    public List<Planos> listarTodos() {
        return planoRepository.findAll();
    }

    public Planos findByTipo(PlanosEnum tipo) {
        return planoRepository.findByTipoPlano(tipo)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado: " + tipo));
    }

    public Planos delete(UUID id) {
        Planos plano = planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));
        planoRepository.delete(plano);
        return plano;
    }
}

