package com.kipper.frit_project_app.service.exception.databsase_consts;

public enum ErrorConsts {
    DATA_NOT_FOUND("Dado não encontrado."),
    REPEATED_DATA_MAIL("O e-mail já está em uso."),
    REPEATED_DATA_PHONE("O telefone já está em uso."),
    HTTP_ID_IS_EMPITY("O Id não pôde ser encontrado.");

    private String err;

    ErrorConsts (String err){
        this.err = err;
    }

    public String getErr() {
        return err;
    }
}