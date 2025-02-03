package com.kipper.frit_project_app.service.exception;

public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(Object object) {
        super("Resource not found: " + object);
    }
}
