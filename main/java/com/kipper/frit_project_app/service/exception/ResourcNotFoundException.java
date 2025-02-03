package com.kipper.frit_project_app.service.exception;

public class ResourcNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    public ResourcNotFoundException(Object object) {
        super("Resource not found: " + object);
    }
}
