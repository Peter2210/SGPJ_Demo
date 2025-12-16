package com.sgpj.backend.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
        MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach( 
            error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(NomeGrupoExistenteException.class)
    public ResponseEntity<Map<String, String>> handleNomeGrupoExistenteException(NomeGrupoExistenteException ex){

        log.warn("Nome do Grupo já existente {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Nome do Grupo já existente");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(GrupoPesquisaNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleGrupoPesquisaNaoEncontradoException(NomeGrupoExistenteException ex){

        log.warn("Grupo de pesquisa não encontrado por ID {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Grupo de Pesquisa não encontrado por ID");
        return ResponseEntity.badRequest().body(errors);
    }
}