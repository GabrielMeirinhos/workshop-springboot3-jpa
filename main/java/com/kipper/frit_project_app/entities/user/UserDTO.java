package com.kipper.frit_project_app.entities.user;

import com.kipper.frit_project_app.entities.dto.OrderDTO;
import com.kipper.frit_project_app.entities.enums.UserRole;
import java.util.List;

public record UserDTO(
        String name,
        String email,
        String phone,
        UserRole role
) {
    public UserDTO(User newUser) {
        this(
                newUser.getName(),
                newUser.getEmail(),
                newUser.getPhone(),
                newUser.getRole()
        );
    }

}
