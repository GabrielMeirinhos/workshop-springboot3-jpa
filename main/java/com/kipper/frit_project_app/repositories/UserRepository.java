package com.kipper.frit_project_app.repositories;

import com.kipper.frit_project_app.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByPhone(String phone);
}
