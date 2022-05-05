package com.example.vinhedo.v1.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7129509748329495954L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
