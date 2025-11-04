package com.pierani.saaid.Aushop_saas.Exceptions.Handler;

import com.pierani.saaid.Aushop_saas.Exceptions.BadRequestException;
import com.pierani.saaid.Aushop_saas.Exceptions.BadRequestExceptionDetails;
import com.pierani.saaid.Aushop_saas.Exceptions.ExceptionDetails;
import com.pierani.saaid.Aushop_saas.Exceptions.ValidationExceptionDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre, HttpServletRequest request) {
        log.warn("BadRequestException capturada: {}", bre.getMessage());
        return new ResponseEntity<>(BadRequestExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request")
                .details(bre.getMessage())
                .developerMessage(bre.getClass().getName())
                .path(request.getRequestURI())
                .build(), HttpStatus.BAD_REQUEST);
    }

    // A BadRequestException é lançada quando há um erro de requisição,
    // como parâmetros inválidos ou dados malformados.

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        Map<String, String> errorsMap = new HashMap<>();
        fieldErrors.forEach(fe -> errorsMap.put(fe.getField(), fe.getDefaultMessage()));

        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        log.warn("MethodArgumentNotValidException capturada: campos inválidos: {}", fields);

        return new ResponseEntity<>(ValidationExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Validation Error")
                .details("Validation failed for one or more fields")
                .developerMessage(exception.getClass().getName())
                .path(request.getRequestURI())
                .validationErrors(errorsMap)
                .build(), HttpStatus.BAD_REQUEST);

        // O MethodArgumentNotValidException é lançado quando a validação dos argumentos do método falha,
        // geralmente devido a anotações de validação como @NotNull, @Size, etc.
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDetails> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpServletRequest request) {
        log.warn("HttpMessageNotReadableException capturada: {}", ex.getMessage());
        return new ResponseEntity<>(ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Malformed JSON request")
                .details("Request body is malformed or unreadable")
                .developerMessage(ex.getClass().getName())
                .path(request.getRequestURI())
                .build(), HttpStatus.BAD_REQUEST);

        // A HttpMessageNotReadableException é lançada quando o corpo da requisição não pode ser lido,
        // geralmente devido a um JSON malformado ou incompatível com o modelo esperado.
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExceptionDetails> handleNoHandlerFound(NoHandlerFoundException ex, HttpServletRequest request) {
        log.warn("NoHandlerFoundException capturada: {}", ex.getMessage());
        return new ResponseEntity<>(ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .details("No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL())
                .developerMessage(ex.getClass().getName())
                .path(request.getRequestURI())
                .build(), HttpStatus.NOT_FOUND);

        // A NoHandlerFoundException é lançada quando nenhuma rota corresponde à requisição feita,
        // resultando em um erro 404 Not Found.
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handleGenericException(Exception ex, HttpServletRequest request) {
        log.error("Exception genérica capturada: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .title("Internal Server Error")
                .details("Unexpected error")
                .developerMessage(ex.getClass().getName())
                .path(request.getRequestURI())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);

        // A Exception genérica é capturada para lidar com qualquer outro tipo de erro não tratado,
        // garantindo que a aplicação não quebre e forneça uma resposta adequada ao cliente.
    }
}
