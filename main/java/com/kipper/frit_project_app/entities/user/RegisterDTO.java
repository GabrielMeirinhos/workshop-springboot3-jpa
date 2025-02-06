package com.kipper.frit_project_app.entities.user;

import com.kipper.frit_project_app.entities.enums.UserRole;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterDTO(
        Long id,
        String email,
        String name,
        String password,
        String phone,
        UserRole role) {
}
