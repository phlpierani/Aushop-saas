package com.pierani.saaid.Aushop_saas.Exceptions;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails{ // Classe para detalhes de exceção de validação
    private final Map<String, String> validationErrors; // mapa de campo -> mensagem
}
