package com.kipper.frit_project_app.service.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource not found: " + id);
    }
}
