package com.kipper.frit_project_app.service.exception;

public class DataIntegrityViolationException extends RuntimeException {

    public DataIntegrityViolationException(String msg) {
        super(msg);
    }
}
