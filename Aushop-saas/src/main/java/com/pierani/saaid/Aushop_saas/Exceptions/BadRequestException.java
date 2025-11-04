package com.pierani.saaid.Aushop_saas.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException { // Exceção personalizada para erros de requisição inválida
    public BadRequestException(String message) {
        super(message);
    }
}
