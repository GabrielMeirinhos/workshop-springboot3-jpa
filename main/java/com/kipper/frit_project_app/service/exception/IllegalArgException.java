package com.kipper.frit_project_app.service.exception;

public class IllegalArgException extends RuntimeException {
    public IllegalArgException() {
        super("password must be at least 8 characters");
    }
}
