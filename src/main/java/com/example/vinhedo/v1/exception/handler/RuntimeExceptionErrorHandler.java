package com.example.vinhedo.v1.exception.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RuntimeExceptionErrorHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> resourceNotFoundErrorHandler(RuntimeException ex) {
        log.error("NotFoundError error", ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
