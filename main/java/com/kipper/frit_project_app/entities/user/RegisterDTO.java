package com.kipper.frit_project_app.entities.user;

import com.kipper.frit_project_app.entities.enums.UserRole;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterDTO (
        Long id,
       @NotBlank @Email String email,
       @NotBlank String name,
       @NotBlank @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$") String password,
       @NotBlank String phone,
        UserRole role) {}
