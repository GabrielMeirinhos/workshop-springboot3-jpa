package com.kipper.frit_project_app.service.exception;

public class HttpRequestMethodNotSupportedException extends RuntimeException {
    public HttpRequestMethodNotSupportedException(String message) {
        super(message);
    }
}
