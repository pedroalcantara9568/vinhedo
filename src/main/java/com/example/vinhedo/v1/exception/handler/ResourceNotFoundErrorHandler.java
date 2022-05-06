package com.example.vinhedo.v1.exception.handler;


import com.example.vinhedo.v1.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ResourceNotFoundErrorHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundErrorHandler(ResourceNotFoundException ex) {
        log.error("NotFoundError error", ex);
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
