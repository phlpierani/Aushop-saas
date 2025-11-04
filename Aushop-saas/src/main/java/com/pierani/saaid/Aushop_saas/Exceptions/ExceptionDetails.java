package com.pierani.saaid.Aushop_saas.Exceptions;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
public class ExceptionDetails { // Classe base para detalhes de exceção
        protected String title;
        protected int status;
        protected String details;
        protected String developerMessage;
        protected LocalDateTime timestamp;
    protected String path; // caminho da requisição
    protected Map<String, String> errors; // opcional: campo -> mensagem (para validação)
    }


